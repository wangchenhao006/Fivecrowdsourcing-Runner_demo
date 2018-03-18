package com.dao;

import java.util.List;

import com.entity.Runner;

public interface IRunnerDao {
    public List<Runner> findRunners();
    public Integer insertValidatedRunners(List<Runner> validatedRunners);
    public Integer deleteRunnersfromTemp(List<Runner> validatedRunners);
}
