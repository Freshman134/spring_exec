package com.howieLuk.spring_exec.exec.dao.mappers;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.howieLuk.spring_exec.exec.pojo.Student;

@Repository("studentDao")
@Transactional
public interface StudentDao extends BaseDao<Student> {
	
}
