package com.skilldistillery.rewardforpay.data;

import java.time.LocalDateTime;
import java.util.List;

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
import com.skilldistillery.rewardforpay.entities.UserRole;
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
		if(pamount>=remainder) {
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
	@Override
	public List<PointAwarded> claimedInitial(int employeeId) {
		String keyword = "Initial Point Award";
		keyword = "%" + keyword + "%";
		String awaredquery = "SELECT pa FROM PointAwarded pa WHERE employee_id = :employeeId AND pa.description LIKE :keyword";
		List<PointAwarded> awarded = em.createQuery(awaredquery, PointAwarded.class)
				.setParameter("employeeId", employeeId).setParameter("keyword", keyword).getResultList();
		
		return awarded;
	}
	@Override
	public List<PointRedemption> claimedInitialT(int employeeId){

		String awaredquery = "SELECT pr FROM PointRedemption pr WHERE employee_id = :employeeId AND reward_id=5";
		List<PointRedemption> awarded = em.createQuery(awaredquery, PointRedemption.class)
				.setParameter("employeeId", employeeId).getResultList();
		return awarded;
}
	public List<Employee> searchAll(String keyword) {
		keyword = "%" + keyword + "%";

		String sql = "SELECT e FROM Employee e WHERE e.firstName LIKE :keyword OR e.lastName LIKE :keyword OR e.user.username LIKE :keyword OR e.department.name LIKE :keyword";

		return em.createQuery(sql, Employee.class).setParameter("keyword", keyword).getResultList();
	}
	public List<PointAwarded> showEvents(){
		String keyword = "EVENT:";
		keyword = "%" + keyword + "%";
		String awaredquery = "SELECT pa FROM PointAwarded pa WHERE pa.description LIKE :keyword";
		List<PointAwarded> awarded = em.createQuery(awaredquery, PointAwarded.class)
				.setParameter("keyword", keyword).getResultList();
		return awarded;
	}
}
