package cn.zhanglu.ssh.dao;

import cn.zhanglu.ssh.entity.User;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

@Repository("userDao")
public class UserDaoImpl implements UserDao {

    @Resource
    private HibernateTemplate hibernateTemplate;

    @Override
    public User findByName(String username) {
        /*
		Session session = HibernateUtil.getSession();

		Transaction t = session.beginTransaction();

		String hql = "from User where username=?";

		Query query = session.createQuery(hql);
		query.setString(0,username);
		User user = (User) query.uniqueResult();

		t.commit();
		session.close();

		return user;
		*/

        String hql = "from User where username=?";
        List<User> userList =  (List<User>) hibernateTemplate.find(hql,username);
        if(userList.isEmpty()) {
            return null;
        }
        return userList.get(0);
    }

}
