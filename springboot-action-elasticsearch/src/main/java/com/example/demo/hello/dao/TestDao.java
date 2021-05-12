package com.example.demo.hello.dao;

import com.example.demo.hello.bean.TestBean;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

public interface TestDao extends ElasticsearchRepository<TestBean, Long> {

    List<TestBean> findByName(String name);

    List<TestBean> findByNameOrDesc(String name, String text);


}
