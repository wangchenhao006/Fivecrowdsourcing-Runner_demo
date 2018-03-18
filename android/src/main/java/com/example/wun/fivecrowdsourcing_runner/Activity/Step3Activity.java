package com.example.wun.fivecrowdsourcing_runner.Activity;

import android.annotation.TargetApi;
import android.content.ContentUris;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.DocumentsContract;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.wun.fivecrowdsourcing_runner.Bean.Runner;
import com.example.wun.fivecrowdsourcing_runner.DataConfig;
import com.example.wun.fivecrowdsourcing_runner.Presenter.Step3Presenter;
import com.example.wun.fivecrowdsourcing_runner.R;
import com.example.wun.fivecrowdsourcing_runner.Utils.UploadUtil;
import com.example.wun.fivecrowdsourcing_runner.View.Step3View;

import java.io.File;

public class Step3Activity extends AppCompatActivity implements Step3View {
    private Runner runner = new Runner();
    TextView title;
    ImageView healthcert;
    Button click_healthcert;
    //EditText name_edit;
    EditText idcardnumber_edit;
    Button thrid_step;
    String healthcertphoto;
    Step3Presenter step3Presenter = new Step3Presenter(Step3Activity.this);

    private static final int CHOOSE_HEALTHCERT =3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_step3);
        initView();
    }

    private void initView() {
        //获得商家信息
        runner = (Runner) getIntent().getSerializableExtra("runner");
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        title=findViewById(R.id.title);
        title.setText("第三步");
        healthcert = findViewById(R.id.healthcert);
        click_healthcert = findViewById(R.id.click_idcard);
        //上传健康证
        click_healthcert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openAlbum(CHOOSE_HEALTHCERT);
            }
        });
       // name_edit = findViewById(R.id.name_edit);
        idcardnumber_edit = findViewById(R.id.idcardnumber_edit);
        thrid_step = findViewById(R.id.third_step);
        thrid_step.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String requestURL = DataConfig.URL + DataConfig.URL_UploadImage;
                //上传身份证
                File healthcertfile= new File(healthcertphoto);
                UploadUtil.uploadFile(healthcertfile, requestURL, runner);
                //身份证信息传送
                step3Presenter.sendImage(String.valueOf(idcardnumber_edit.getText()), runner,healthcertfile.getName());
            }
        });
    }

    private void openAlbum(int FLAG) {
        Intent intent = new Intent("android.intent.action.GET_CONTENT");
        intent.setType("image/*");
        startActivityForResult(intent,FLAG);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        switch (requestCode) {
            case CHOOSE_HEALTHCERT:
                if (resultCode == RESULT_OK) {
                    //判断手机系统版本号
                    if (Build.VERSION.SDK_INT >= 19) {
                        handleImageOnKitKat(data, CHOOSE_HEALTHCERT);
                    }
                }
                break;
            default:
                break;
        }
    }
    @TargetApi(19)
    private void handleImageOnKitKat(Intent data, int FLAG) {
        String imagePath = null;
        Uri uri = data.getData();
        if (DocumentsContract.isDocumentUri(this, uri)) {
            //如果是document类型的Uri,则通过doucument id处理
            String docId = DocumentsContract.getDocumentId(uri);
            if ("com.android.providers.media.documents".equals(uri.getAuthority())) {
                String id = docId.split(":")[1];//解析出数字id
                String selection = MediaStore.Images.Media._ID + "=" + id;
                imagePath = getImagePath(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, selection);
            } else if ("com.android.providers.downloads.documents".equals(uri.getAuthority())) {
                Uri contentUri = ContentUris.withAppendedId(Uri.parse("content://downloads/public_downloads"), Long.valueOf(docId));
                imagePath = getImagePath(contentUri, null);
            }
        } else if ("content".equalsIgnoreCase(uri.getScheme())) {
            //如果是content类型的Uri,则使用普通方式处理
            imagePath = getImagePath(uri, null);
        } else if ("file".equalsIgnoreCase(uri.getScheme())) {
            //如果是file类型的Uri，直接获取图片路径
            imagePath = uri.getPath();
        }
        displayImge(imagePath,FLAG);//根据图片路径显示图片
    }

    private void displayImge(String imagePath, int FLAG) {
        Bitmap bitmap;
        if (imagePath != null) {
            bitmap=zoomIn(imagePath);//缩小照片
            switch (FLAG) {
                case CHOOSE_HEALTHCERT:
                   healthcertphoto = imagePath;
                    healthcert.setImageBitmap(bitmap);
                    break;
                default:
                    break;
            }
        } else {
            Toast.makeText(this, "加载图片失败!", Toast.LENGTH_SHORT).show();
        }

    }

    private Bitmap zoomIn(String imagePath) {
        int iw, ih, vw, vh;//图片的宽度、高度 imageView的宽度高度
        Bitmap bitmap;
        BitmapFactory.Options option = new BitmapFactory.Options();
        option.inJustDecodeBounds = true;//设置选项：只读取图像文件信息而不加载图像文件
        BitmapFactory.decodeFile(imagePath, option);

        iw = option.outWidth;
        ih = option.outHeight;
        vw = healthcert.getWidth();
        vh = healthcert.getHeight();//根据身份证尺寸计算

        int scaleFactor = Math.min(iw / vw, ih / vh);//计算缩小比率

        option.inJustDecodeBounds = false;//关闭选项
        option.inSampleSize = scaleFactor;//设置缩小比率

        bitmap = BitmapFactory.decodeFile(imagePath, option);
        return bitmap;
    }

    private String getImagePath(Uri externalContentUri, String selection) {
        String path = null;
        //通过Uri和selection来获取真实的图片路径
        Cursor cursor = getContentResolver().query(externalContentUri, null, selection, null, null);
        if (cursor != null) {
            if (cursor.moveToFirst()) {
                path = cursor.getString(cursor.getColumnIndex(MediaStore.Images.Media.DATA));
            }
            cursor.close();
        }
        return path;
    }

    @Override
    public void finishStep3(Runner runner) {
        //Toast.makeText(Step3Activity.this, "您已经填写完成所有信息，请等待审核!", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(Step3Activity.this, MainActivity.class);
        intent.putExtra("runner",runner);
        startActivity(intent);
    }
}
