//package hello.session;
//
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.session.ExpiringSession;
//import org.springframework.session.SessionRepository;
//import org.springframework.session.config.annotation.web.http.EnableSpringHttpSession;
//import org.springframework.stereotype.Component;
//
//import java.util.ArrayList;
//import java.util.LinkedList;
//import java.util.List;
//import java.util.Set;
//
//@Component
//@EnableSpringHttpSession
//public class CustomSessionRepository implements SessionRepository<ExpiringSession>{
//
//    List<ExpiringSession> sessionList = new LinkedList<>();
//
//
//    @Override
//    public ExpiringSession createSession() {
//        ExpiringSession session = new ExpiringSession() {
//            @Override
//            public long getCreationTime() {
//                return 0;
//            }
//
//            @Override
//            public void setLastAccessedTime(long lastAccessedTime) {
//
//            }
//
//            @Override
//            public long getLastAccessedTime() {
//                return 0;
//            }
//
//            @Override
//            public void setMaxInactiveIntervalInSeconds(int interval) {
//
//            }
//
//            @Override
//            public int getMaxInactiveIntervalInSeconds() {
//                return 0;
//            }
//
//            @Override
//            public boolean isExpired() {
//                return false;
//            }
//
//            @Override
//            public String getId() {
//                return null;
//            }
//
//            @Override
//            public <T> T getAttribute(String attributeName) {
//                return null;
//            }
//
//            @Override
//            public Set<String> getAttributeNames() {
//                return null;
//            }
//
//            @Override
//            public void setAttribute(String attributeName, Object attributeValue) {
//
//            }
//
//            @Override
//            public void removeAttribute(String attributeName) {
//
//            }
//        }
//        return null;
//    }
//
//    @Override
//    public void save(ExpiringSession session) {
//
//    }
//
//    @Override
//    public ExpiringSession getSession(String id) {
//        return null;
//    }
//
//    @Override
//    public void delete(String id) {
//
//    }
//}
