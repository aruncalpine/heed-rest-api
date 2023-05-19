package com.zno.heed.chatdata;

import java.util.List;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.zno.heed.user.User;

public interface ChatRepository  extends JpaRepository<ChatUsers, Integer>{


	@Query(value="select \n"
			+ "	c.date as date,\n"
			+ "	u1.first_name as firstName,\n"
			+ "	u1.mobile_phone as mobilePhone\n"
			+ "from chat_users c \n"
			+ "inner join user u1 on c.dest_user_id = u1.id\n"
		//	+ "inner join user u2 on c.src_user_id = u2.id\n"
			+ "where c.src_user_id=:srcUserId", nativeQuery=true)
	List<ChatUsersView>findDateAndDestUserFields(@Param("srcUserId")Long srcUserId);

}
