package com.skilldistillery.rewardforpay.data;

import java.time.LocalDateTime;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.data.convert.JodaTimeConverters.LocalDateTimeToDateConverter;
import org.springframework.stereotype.Service;

import com.skilldistillery.rewardforpay.entities.Employee;
import com.skilldistillery.rewardforpay.entities.PointAwarded;
import com.skilldistillery.rewardforpay.entities.PointRedemption;
import com.skilldistillery.rewardforpay.entities.Prize;
import com.skilldistillery.rewardforpay.entities.Status;
@Service
@Transactional
public class AdminDAOImpl implements AdminDAO {

	@PersistenceContext
	private EntityManager em;

	@Override
	public boolean updateStatus(Object obj,int statusId) {
		boolean changed = false;
		if(obj instanceof Prize) {
			((Prize) obj).setStatus(em.find(Status.class, statusId));
			System.out.println("I made it here");
			changed =true;
		}
		if(obj instanceof Employee) {
			((Employee) obj).setRequestStatus(em.find(Status.class, statusId));
			changed =true;
		}
		if(obj instanceof PointAwarded) {
			((PointAwarded) obj).setStatus(em.find(Status.class, statusId));
			changed =true;
		}
		return changed;
	}
	@Override
	public boolean deleteEmployeeTest(Employee emp) {
			emp.setRequestStatus(em.find(Status.class, 4));
		return true;
	}

	@Override
	public boolean createRedemption(Prize p, Employee e, int remainder) {
		boolean redeemed =false;
		int pamount =p.getPoints();
		if(pamount>remainder) {
			return redeemed;
		}else {
		PointRedemption pr = new PointRedemption();
		pr.setEmployee(e);
		pr.setPrize(p);
		em.persist(pr);
		redeemed = true;
		return redeemed;
		}
	}
//	@Override
//	public PointAwarded updateAward(int awardId, PointAwarded pointAward) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//	
//	
//	
//	@Override
//	public PointRedemption updateRedemption(int employeeId, int rewardId) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public PointRedemption deleteRedemption(int employeeId, int rewardId) {
//		// TODO Auto-generated method stub
//		return null;
//	}
}
