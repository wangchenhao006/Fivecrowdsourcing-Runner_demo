<%@ page language="java" import="java.util.*" pageEncoding="utf-8"
	contentType="text/html; charset=utf-8"%>
<%@ page import="com.entity.*"%>
<%@ page import="com.dao.*"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
<meta charset="utf-8" />
<title>商户审核</title>

<meta name="description" content="Static &amp; Dynamic Tables" />
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, maximum-scale=1.0" />

<!-- bootstrap & fontawesome -->
<link rel="stylesheet" href="../assets/css/bootstrap.min.css" />
<link rel="stylesheet" href="../assets/css/font-awesome.min.css" />

<!-- page specific plugin styles -->

<!-- text fonts -->
<link rel="stylesheet" href="../assets/css/ace-fonts.css" />

<!-- ace styles -->
<link rel="stylesheet" href="../assets/css/ace.min.css"
	id="main-ace-style" />

<!--[if lte IE 9]>
			<link rel="stylesheet" href="../assets/css/ace-part2.min.css" />
		<![endif]-->
<link rel="stylesheet" href="../assets/css/ace-skins.min.css" />
<link rel="stylesheet" href="../assets/css/ace-rtl.min.css" />

<!--[if lte IE 9]>
		  <link rel="stylesheet" href="../assets/css/ace-ie.min.css" />
		<![endif]-->

<!-- inline styles related to this page -->

<!-- ace settings handler -->
<script src="../assets/js/ace-extra.min.js"></script>

<!-- HTML5shiv and Respond.js for IE8 to support HTML5 elements and media queries -->

<!--[if lte IE 8]>
		<script src="../assets/js/html5shiv.min.js"></script>
		<script src="../assets/js/respond.min.js"></script>
		<![endif]-->
</head>

<body class="no-skin">
	<!-- #section:basics/navbar.layout -->
	<div id="navbar" class="navbar navbar-default">
		<script type="text/javascript">
			try {
				ace.settings.check('navbar', 'fixed')
			} catch (e) {
			}
		</script>

		<div class="navbar-container" id="navbar-container">
			<!-- #section:basics/sidebar.mobile.toggle -->
			<button type="button" class="navbar-toggle menu-toggler pull-left"
				id="menu-toggler">
				<span class="sr-only">Toggle sidebar</span> <span class="icon-bar"></span>

				<span class="icon-bar"></span> <span class="icon-bar"></span>
			</button>

			<!-- /section:basics/sidebar.mobile.toggle -->
			<div class="navbar-header pull-left">
				<!-- #section:basics/navbar.layout.brand -->
				<a href="#" class="navbar-brand"> <small> <i
						class="fa fa-coffee"></i> &nbsp;众包同城跑腿配送服务平台
				</small>
				</a>

				<!-- /section:basics/navbar.layout.brand -->

				<!-- #section:basics/navbar.toggle -->

				<!-- /section:basics/navbar.toggle -->
			</div>

			<!-- #section:basics/navbar.dropdown -->
			<div class="navbar-buttons navbar-header pull-right"
				role="navigation">
				<ul class="nav ace-nav">


					<li class="purple"><a data-toggle="dropdown"
						class="dropdown-toggle" href="#"> <i
							class="ace-icon fa fa-bell icon-animated-bell"></i> <span
							class="badge badge-important">8</span>
					</a>

						<ul
							class="dropdown-menu-right dropdown-navbar navbar-pink dropdown-menu dropdown-caret dropdown-close">
							<li class="dropdown-header"><i
								class="ace-icon fa fa-exclamation-triangle"></i> 8 Notifications
							</li>

							<li><a href="#">
									<div class="clearfix">
										<span class="pull-left"> <i
											class="btn btn-xs no-hover btn-pink fa fa-comment"></i> New
											Comments
										</span> <span class="pull-right badge badge-info">+12</span>
									</div>
							</a></li>

							<li><a href="#"> <i
									class="btn btn-xs btn-primary fa fa-user"></i> Bob just signed
									up as an editor ...
							</a></li>

							<li><a href="#">
									<div class="clearfix">
										<span class="pull-left"> <i
											class="btn btn-xs no-hover btn-success fa fa-shopping-cart"></i>
											New Orders
										</span> <span class="pull-right badge badge-success">+8</span>
									</div>
							</a></li>

							<li><a href="#">
									<div class="clearfix">
										<span class="pull-left"> <i
											class="btn btn-xs no-hover btn-info fa fa-twitter"></i>
											Followers
										</span> <span class="pull-right badge badge-info">+11</span>
									</div>
							</a></li>

							<li class="dropdown-footer"><a href="#"> See all
									notifications <i class="ace-icon fa fa-arrow-right"></i>
							</a></li>
						</ul></li>

					<li class="green"><a data-toggle="dropdown"
						class="dropdown-toggle" href="#"> <i
							class="ace-icon fa fa-envelope icon-animated-vertical"></i> <span
							class="badge badge-success">5</span>
					</a>

						<ul
							class="dropdown-menu-right dropdown-navbar dropdown-menu dropdown-caret dropdown-close">
							<li class="dropdown-header"><i
								class="ace-icon fa fa-envelope-o"></i> 5 Messages</li>

							<li class="dropdown-content">
								<ul class="dropdown-menu dropdown-navbar">
									<li><a href="#"> <img
											src="../assets/avatars/avatar.png" class="msg-photo"
											alt="Alex's Avatar" /> <span class="msg-body"> <span
												class="msg-title"> <span class="blue">Alex:</span>
													Ciao sociis natoque penatibus et auctor ...
											</span> <span class="msg-time"> <i
													class="ace-icon fa fa-clock-o"></i> <span>a moment
														ago</span>
											</span>
										</span>
									</a></li>

									<li><a href="#"> <img
											src="../assets/avatars/avatar3.png" class="msg-photo"
											alt="Susan's Avatar" /> <span class="msg-body"> <span
												class="msg-title"> <span class="blue">Susan:</span>
													Vestibulum id ligula porta felis euismod ...
											</span> <span class="msg-time"> <i
													class="ace-icon fa fa-clock-o"></i> <span>20 minutes
														ago</span>
											</span>
										</span>
									</a></li>

									<li><a href="#"> <img
											src="../assets/avatars/avatar4.png" class="msg-photo"
											alt="Bob's Avatar" /> <span class="msg-body"> <span
												class="msg-title"> <span class="blue">Bob:</span>
													Nullam quis risus eget urna mollis ornare ...
											</span> <span class="msg-time"> <i
													class="ace-icon fa fa-clock-o"></i> <span>3:15 pm</span>
											</span>
										</span>
									</a></li>

									<li><a href="#"> <img
											src="../assets/avatars/avatar2.png" class="msg-photo"
											alt="Kate's Avatar" /> <span class="msg-body"> <span
												class="msg-title"> <span class="blue">Kate:</span>
													Ciao sociis natoque eget urna mollis ornare ...
											</span> <span class="msg-time"> <i
													class="ace-icon fa fa-clock-o"></i> <span>1:33 pm</span>
											</span>
										</span>
									</a></li>

									<li><a href="#"> <img
											src="../assets/avatars/avatar5.png" class="msg-photo"
											alt="Fred's Avatar" /> <span class="msg-body"> <span
												class="msg-title"> <span class="blue">Fred:</span>
													Vestibulum id penatibus et auctor ...
											</span> <span class="msg-time"> <i
													class="ace-icon fa fa-clock-o"></i> <span>10:09 am</span>
											</span>
										</span>
									</a></li>
								</ul>
							</li>

							<li class="dropdown-footer"><a href="inbox.html"> See
									all messages <i class="ace-icon fa fa-arrow-right"></i>
							</a></li>
						</ul></li>

					<!-- #section:basics/navbar.user_menu -->
					<li class="light-blue"><a data-toggle="dropdown" href="#"
						class="dropdown-toggle"> <img class="nav-user-photo"
							src="../assets/avatars/user.jpg" alt="Jason's Photo" /> <span
							class="user-info"> <small>Welcome,</small> Jason
						</span> <i class="ace-icon fa fa-caret-down"></i>
					</a>

						<ul
							class="user-menu dropdown-menu-right dropdown-menu dropdown-yellow dropdown-caret dropdown-close">
							<li><a href="#"> <i class="ace-icon fa fa-cog"></i>
									Settings
							</a></li>

							<li><a href="profile.html"> <i
									class="ace-icon fa fa-user"></i> Profile
							</a></li>

							<li class="divider"></li>

							<li><a href="#"> <i class="ace-icon fa fa-power-off"></i>
									Logout
							</a></li>
						</ul></li>

					<!-- /section:basics/navbar.user_menu -->
				</ul>
			</div>

			<!-- /section:basics/navbar.dropdown -->
		</div>
		<!-- /.navbar-container -->
	</div>

	<!-- /section:basics/navbar.layout -->
	<div class="main-container" id="main-container">
		<script type="text/javascript">
			try {
				ace.settings.check('main-container', 'fixed')
			} catch (e) {
			}
		</script>

		<!-- #section:basics/sidebar -->
		<div id="sidebar" class="sidebar                  responsive">
			<script type="text/javascript">
				try {
					ace.settings.check('sidebar', 'fixed')
				} catch (e) {
				}
			</script>

			<div class="sidebar-shortcuts" id="sidebar-shortcuts">
				<div class="sidebar-shortcuts-large" id="sidebar-shortcuts-large">
					<button class="btn btn-success">
						<i class="ace-icon fa fa-signal"></i>
					</button>

					<button class="btn btn-info">
						<i class="ace-icon fa fa-pencil"></i>
					</button>

					<!-- #section:basics/sidebar.layout.shortcuts -->
					<button class="btn btn-warning">
						<i class="ace-icon fa fa-users"></i>
					</button>

					<button class="btn btn-danger">
						<i class="ace-icon fa fa-cogs"></i>
					</button>

					<!-- /section:basics/sidebar.layout.shortcuts -->
				</div>

				<div class="sidebar-shortcuts-mini" id="sidebar-shortcuts-mini">
					<span class="btn btn-success"></span> <span class="btn btn-info"></span>

					<span class="btn btn-warning"></span> <span class="btn btn-danger"></span>
				</div>
			</div>
			<!-- /.sidebar-shortcuts -->

			<ul class="nav nav-list">


				<li class="active open"><a href="#" class="dropdown-toggle"> <i
						class="menu-icon fa fa-desktop"></i> <span class="menu-text">
							人工审核 </span> <b class="arrow fa fa-angle-down"></b>
				</a> <b class="arrow"></b>

					<ul class="submenu">


						<li class=""><a href="typography.html"> <i
								class="menu-icon fa fa-caret-right"></i> 商户审核
						</a> <b class="arrow"></b></li>

						<li class=""><a href="elements.html"> <i
								class="menu-icon fa fa-caret-right"></i> 跑腿人审核
						</a> <b class="arrow"></b></li>

						<li class=""><a href="buttons.html"> <i
								class="menu-icon fa fa-caret-right"></i> 个体审核
						</a> <b class="arrow"></b></li>


					</ul></li>

				<li class=""><a href="#" class="dropdown-toggle">
						<i class="menu-icon fa fa-list"></i> <span class="menu-text">
							账户管理</span> <b class="arrow fa fa-angle-down"></b>
				</a> <b class="arrow"></b>

					<ul class="submenu">
						<li class=""><a href="tables.html"> <i
								class="menu-icon fa fa-caret-right"></i> 商户管理
						</a> <b class="arrow"></b></li>

						<li class=""><a href="jqgrid.html"> <i
								class="menu-icon fa fa-caret-right"></i> 跑腿人管理
						</a> <b class="arrow"></b></li>
					</ul></li>

				<li class=""><a href="#" class="dropdown-toggle"> <i
						class="menu-icon fa fa-pencil-square-o"></i> <span
						class="menu-text">帮助 </span> <b class="arrow fa fa-angle-down"></b>
				</a> <b class="arrow"></b>

					<ul class="submenu">
						<li class=""><a href="form-elements.html"> <i
								class="menu-icon fa fa-caret-right"></i> 加价表查询
						</a> <b class="arrow"></b></li>

						<li class=""><a href="form-wizard.html"> <i
								class="menu-icon fa fa-caret-right"></i> 天气查询
						</a> <b class="arrow"></b></li>

						<li class=""><a href="wysiwyg.html"> <i
								class="menu-icon fa fa-caret-right"></i> 信用分奖励
						</a> <b class="arrow"></b></li>

					</ul></li>

				<li class=""><a href="widgets.html"> <i
						class="menu-icon fa fa-list-alt"></i> <span class="menu-text">
							关于 </span>
				</a> <b class="arrow"></b></li>
			</ul>
			<!-- /.nav-list -->

			<!-- #section:basics/sidebar.layout.minimize -->
			<div class="sidebar-toggle sidebar-collapse" id="sidebar-collapse">
				<i class="ace-icon fa fa-angle-double-left"
					data-icon1="ace-icon fa fa-angle-double-left"
					data-icon2="ace-icon fa fa-angle-double-right"></i>
			</div>

			<!-- /section:basics/sidebar.layout.minimize -->
			<script type="text/javascript">
				try {
					ace.settings.check('sidebar', 'collapsed')
				} catch (e) {
				}
			</script>
		</div>
		<!-- 在这里进行了更改 -->
		<!-- /section:basics/sidebar -->
		<div class="main-content">


			<!-- /section:basics/content.breadcrumbs -->
			<div class="page-content">
				<!-- #section:settings.box -->
				<div class="ace-settings-container" id="ace-settings-container">
					<div class="btn btn-app btn-xs btn-warning ace-settings-btn"
						id="ace-settings-btn">
						<i class="ace-icon fa fa-cog bigger-150"></i>
					</div>

					<div class="ace-settings-box clearfix" id="ace-settings-box">
						<div class="pull-left width-50">
							<!-- #section:settings.skins -->
							<div class="ace-settings-item">
								<div class="pull-left">
									<select id="skin-colorpicker" class="hide">
										<option data-skin="no-skin" value="#438EB9">#438EB9</option>
										<option data-skin="skin-1" value="#222A2D">#222A2D</option>
										<option data-skin="skin-2" value="#C6487E">#C6487E</option>
										<option data-skin="skin-3" value="#D0D0D0">#D0D0D0</option>
									</select>
								</div>
								<span>&nbsp; 选择皮肤</span>
							</div>

							<!-- /section:settings.skins -->


							<!-- #section:settings.breadcrumbs -->
							<div class="ace-settings-item">
								<input type="checkbox" class="ace ace-checkbox-2"
									id="ace-settings-breadcrumbs" /> <label class="lbl"
									for="ace-settings-breadcrumbs"> 固定导航条</label>
							</div>

							<!-- /section:settings.breadcrumbs -->

							<!-- #section:settings.rtl -->


							<!-- /section:settings.rtl -->

							<!-- #section:settings.container -->
							<div class="ace-settings-item">
								<input type="checkbox" class="ace ace-checkbox-2"
									id="ace-settings-add-container" /> <label class="lbl"
									for="ace-settings-add-container"> 缩略图 </label>
							</div>

							<!-- /section:settings.container -->
						</div>
						<!-- /.pull-left -->

						<div class="pull-left width-50">
							<!-- #section:basics/sidebar.options -->
							<div class="ace-settings-item">
								<input type="checkbox" class="ace ace-checkbox-2"
									id="ace-settings-hover" /> <label class="lbl"
									for="ace-settings-hover"> 子菜单悬浮</label>
							</div>

							<div class="ace-settings-item">
								<input type="checkbox" class="ace ace-checkbox-2"
									id="ace-settings-compact" /> <label class="lbl"
									for="ace-settings-compact"> 边缘导航</label>
							</div>

							<div class="ace-settings-item">
								<input type="checkbox" class="ace ace-checkbox-2"
									id="ace-settings-highlight" /> <label class="lbl"
									for="ace-settings-highlight"> 选中样式</label>
							</div>

							<!-- /section:basics/sidebar.options -->
						</div>
						<!-- /.pull-left -->
					</div>
					<!-- /.ace-settings-box -->
				</div>
				<!-- /.ace-settings-container -->

				<!-- /section:settings.box -->
				<div class="page-content-area">

					<!-- /.page-header -->

					<div class="row">
						<div class="col-xs-12">
							<!-- PAGE CONTENT BEGINS -->




							<div class="row">
								<div class="col-xs-12">
									<h3 class="header smaller lighter blue">待审核商户</h3>


									<!-- <div class="table-responsive"> -->

									<!-- <div class="dataTables_borderWrap"> -->

									<table id="sample-table-2"
										class="table table-striped table-bordered table-hover">
										<thead>
											<tr>
												<th class="center"><label class="position-relative">
														<input type="checkbox" class="ace" /> <span class="lbl"></span>
												</label></th>
												<th>商户id</th>
												<th>商户名称</th>
												<th class="hidden-480">身份证号</th>

												<th><i
													class="ace-icon fa fa-clock-o bigger-110 hidden-480"></i>
													电话</th>
												<th class="hidden-480">地址</th>

												<th></th>
											</tr>
										</thead>

										<tbody>
											<%
												List<Merchant> merchants=(List<Merchant>)session.getAttribute("merchants");
																																																																					Iterator it=merchants.iterator();
																																																	long merchantId;
																																																  String idCardNumber;
																																																	String merchantName;
																																																	String phone;
																																																	String address;
																																																	while(it.hasNext()){
																																																				Merchant merchant=(Merchant)it.next();
																																																				phone=merchant.getPhone();
																																																				address=merchant.getAddress();
																																																				merchantName=merchant.getName();
																																																				idCardNumber=merchant.getIdcardnumber();
																																																				merchantId=merchant.getMerchantid();
											%>

											<tr>
												<td class="center"><label class="position-relative">
														<input type="checkbox" class="ace" /> <span class="lbl"></span>
												</label></td>

												<td><a href="#"><%=merchantId%></a></td>
												<td><%=merchantName%></td>
												<td class="hidden-480"><%=idCardNumber%></td>
												<td><%=phone%></td>

												<td class="hidden-480"><span
													class="label label-sm label-warning"><%=address%></span></td>

												<td>
													<div class="hidden-sm hidden-xs action-buttons">
														<a class="blue"
															href="/FiveCrowdsourcing-Server/merchant_profile.do?merchantId=<%=merchantId%>"
															target="_blank">&nbsp; <i
															class="ace-icon fa fa-search-plus bigger-130"></i>
															&nbsp;详细信息
														</a>
													</div>
												</td>
											</tr>
											<%
												}
											%>
										</tbody>

									</table>
									<p style="padding-top:10px; ">
										<button class="btn btn-info" id="bootbox-confirm"
											onclick="window.location.href='/FiveCrowdsourcing-Server/merchants.do'">保存</button>
									</p>
								</div>
							</div>

							<div id="modal-table" class="modal fade" tabindex="-1">
								<div class="modal-dialog">
									<div class="modal-content">
										<div class="modal-header no-padding">
											<div class="table-header">
												<button type="button" class="close" data-dismiss="modal"
													aria-hidden="true">
													<span class="white">&times;</span>
												</button>
												Results for "Latest Registered Domains
											</div>
										</div>

										<div class="modal-body no-padding">
											<table
												class="table table-striped table-bordered table-hover no-margin-bottom no-border-top">
												<thead>
													<tr>
														<th>Domain</th>
														<th>Price</th>
														<th>Clicks</th>

														<th><i class="ace-icon fa fa-clock-o bigger-110"></i>
															Update</th>
													</tr>
												</thead>

												<tbody>
													<tr>
														<td><a href="#">ace.com</a></td>
														<td>$45</td>
														<td>3,330</td>
														<td>Feb 12</td>
													</tr>

													<tr>
														<td><a href="#">base.com</a></td>
														<td>$35</td>
														<td>2,595</td>
														<td>Feb 18</td>
													</tr>

													<tr>
														<td><a href="#">max.com</a></td>
														<td>$60</td>
														<td>4,400</td>
														<td>Mar 11</td>
													</tr>

													<tr>
														<td><a href="#">best.com</a></td>
														<td>$75</td>
														<td>6,500</td>
														<td>Apr 03</td>
													</tr>

													<tr>
														<td><a href="#">pro.com</a></td>
														<td>$55</td>
														<td>4,250</td>
														<td>Jan 21</td>
													</tr>
												</tbody>
											</table>
										</div>

										<div class="modal-footer no-margin-top">
											<button class="btn btn-sm btn-danger pull-left"
												data-dismiss="modal">
												<i class="ace-icon fa fa-times"></i> Close
											</button>

											<ul class="pagination pull-right no-margin">
												<li class="prev disabled"><a href="#"> <i
														class="ace-icon fa fa-angle-double-left"></i>
												</a></li>

												<li class="active"><a href="#">1</a></li>

												<li><a href="#">2</a></li>

												<li><a href="#">3</a></li>

												<li class="next"><a href="#"> <i
														class="ace-icon fa fa-angle-double-right"></i>
												</a></li>
											</ul>
										</div>
									</div>
									<!-- /.modal-content -->
								</div>
								<!-- /.modal-dialog -->
							</div>
							<!-- PAGE CONTENT ENDS -->
						</div>
						<!-- /.col -->
					</div>

					<!-- /.row -->
				</div>
				<!-- /.page-content-area -->
			</div>
			<!-- /.page-content -->
		</div>
		<!-- /.main-content -->



		<a href="#" id="btn-scroll-up"
			class="btn-scroll-up btn btn-sm btn-inverse"> <i
			class="ace-icon fa fa-angle-double-up icon-only bigger-110"></i>
		</a>
	</div>
	<!-- /.main-container -->

	<!-- basic scripts -->

	<!--[if !IE]> -->
	<script type="text/javascript">
		window.jQuery
				|| document.write("<script src='../assets/js/jquery.min.js'>"
						+ "<"+"/script>");
	</script>

	<!-- <![endif]-->

	<!--[if IE]>
<script type="text/javascript">
 window.jQuery || document.write("<script src='../assets/js/jquery1x.min.js'>"+"<"+"/script>");
</script>
<![endif]-->
	<script type="text/javascript">
		if ('ontouchstart' in document.documentElement)
			document
					.write("<script src='../assets/js/jquery.mobile.custom.min.js'>"
							+ "<"+"/script>");
	</script>
	<script src="../assets/js/bootstrap.min.js"></script>

	<!-- page specific plugin scripts -->
	<script src="../assets/js/jquery.dataTables.min.js"></script>
	<script src="../assets/js/jquery.dataTables.bootstrap.js"></script>

	<!-- ace scripts -->
	<script src="../assets/js/ace-elements.min.js"></script>
	<script src="../assets/js/ace.min.js"></script>

	<!-- inline scripts related to this page -->
	<script type="text/javascript">
		jQuery(function($) {
			var oTable1 = $('#sample-table-2')
			//.wrap("<div class='dataTables_borderWrap' />")   //if you are applying horizontal scrolling (sScrollX)
			.dataTable({
				bAutoWidth : false,
				"aoColumns" : [ {
					"bSortable" : false
				}, null, null, null, null, null, {
					"bSortable" : false
				} ],
				"aaSorting" : [],

			//,
			//"sScrollY": "200px",
			//"bPaginate": false,

			//"sScrollX": "100%",
			//"sScrollXInner": "120%",
			//"bScrollCollapse": true,
			//Note: if you are applying horizontal scrolling (sScrollX) on a ".table-bordered"
			//you may want to wrap the table inside a "div.dataTables_borderWrap" element

			//"iDisplayLength": 50
			});
			/**
			var tableTools = new $.fn.dataTable.TableTools( oTable1, {
				"sSwfPath": "../../copy_csv_xls_pdf.swf",
			    "buttons": [
			        "copy",
			        "csv",
			        "xls",
					"pdf",
			        "print"
			    ]
			} );
			$( tableTools.fnContainer() ).insertBefore('#sample-table-2');
			 */

			$(document).on(
					'click',
					'th input:checkbox',
					function() {
						var that = this;
						$(this).closest('table').find(
								'tr > td:first-child input:checkbox').each(
								function() {
									this.checked = that.checked;
									$(this).closest('tr').toggleClass(
											'selected');
								});
					});

			$('[data-rel="tooltip"]').tooltip({
				placement : tooltip_placement
			});
			function tooltip_placement(context, source) {
				var $source = $(source);
				var $parent = $source.closest('table')
				var off1 = $parent.offset();
				var w1 = $parent.width();

				var off2 = $source.offset();
				//var w2 = $source.width();

				if (parseInt(off2.left) < parseInt(off1.left)
						+ parseInt(w1 / 2))
					return 'right';
				return 'left';
			}

		})
	</script>

	<!-- the following scripts are used in demo only for onpage help and you don't need them -->
	<link rel="stylesheet" href="../assets/css/ace.onpage-help.css" />
	<link rel="stylesheet" href="../docs/assets/js/themes/sunburst.css" />
	<script type="text/javascript">
		jQuery(function($) {
			$("#bootbox-confirm").on(ace.click_event, function() {
				bootbox.confirm("Are you sure?", function(result) {
					if (result) {
						//
					}
				});
			});
		});
	</script>
	<script type="text/javascript">
		ace.vars['base'] = '..';
	</script>
	<script src="../assets/js/ace/elements.onpage-help.js"></script>
	<script src="../assets/js/ace/ace.onpage-help.js"></script>
	<script src="../docs/assets/js/rainbow.js"></script>
	<script src="../docs/assets/js/language/generic.js"></script>
	<script src="../docs/assets/js/language/html.js"></script>
	<script src="../docs/assets/js/language/css.js"></script>
	<script src="../docs/assets/js/language/javascript.js"></script>
</body>
</html>
