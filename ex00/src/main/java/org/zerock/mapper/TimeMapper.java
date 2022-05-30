package org.zerock.mapper;

import org.apache.ibatis.annotations.Select;

public interface TimeMapper {
	
	// ;(세미콜론)이 없어야한다.
	@Select("select sysdate from dual")
	public String getTime();
	

	public String getTime2();
}
