package com.example.demo.hello;

import com.example.demo.hello.bean.TestBean;
import com.example.demo.hello.dao.TestDao;
import org.eclipse.jetty.util.ajax.JSON;
import org.elasticsearch.index.query.FuzzyQueryBuilder;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.index.query.QueryStringQueryBuilder;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.SearchHit;
import org.springframework.data.elasticsearch.core.query.NativeSearchQuery;
import org.springframework.data.elasticsearch.core.query.Query;
import org.springframework.data.elasticsearch.repository.config.EnableReactiveElasticsearchRepositories;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;

@RunWith(SpringRunner.class)
@SpringBootTest
class DemoApplicationTests {

	@Autowired
	TestDao testDao;

	@Test
	public void test01() throws IOException {
		Iterable<TestBean> search = testDao.search(new FuzzyQueryBuilder("name", "格梅"));
		search.forEach(ele->{
			System.out.println("@@@:"+ele);
		});
	}

	@Test
	public void test02() throws IOException {
		Pageable pageable = PageRequest.of(1, 10);
		Query query = new NativeSearchQuery(new FuzzyQueryBuilder("name", "格")).setPageable(pageable);
		Page<TestBean> search = testDao.search(query);
		search.getContent().forEach(ele->{
			System.out.println("###:"+ele);
		});
	}


}
