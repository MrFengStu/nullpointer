package com.exp.question.questionHateRecord.dao;

import org.springframework.stereotype.Repository;

import com.exp.entity.QuestionHateRecord;
import com.framework.BaseDao;

@Repository
public class QuestionHateRecordDaoImpl  extends BaseDao<QuestionHateRecord, String>{
    /**
     * @function 保存question获踩记录
     * @author tangwenru
     * @param q
     */
	public void saveQuestionHateRecord(QuestionHateRecord q){
		try {
			this.save(q);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/**
	 * @function 根据questionId,userInfoId查询单个question获踩记录
	 * @author tangwenru
	 * @param questionId
	 * @param userInfoId
	 * @return
	 */
	public QuestionHateRecord findQuestionHateRecord(Integer questionId,Integer userInfoId){
		try {
			return super.findOne("from QuestionHateRecord q where q.question.questionId=? and q.userInfo.userInfoId=?",new Object[] { questionId, userInfoId });
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
    }
	/**
	 * @function 更新question获踩记录
	 * @author tangwenru
	 * @param q
	 */
	public void updateHateQuestioneRecord(QuestionHateRecord q){
		try {
			this.update(q);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
