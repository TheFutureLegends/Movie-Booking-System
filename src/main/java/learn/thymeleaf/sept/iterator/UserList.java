package learn.thymeleaf.sept.iterator;

import learn.thymeleaf.sept.entity.User;

import java.util.ArrayList;
import java.util.List;

public class UserList implements ListIterator {

    List<User> users = new ArrayList<>();
    int currentItem = 0;

    @Override
    public boolean hasNext() {
        if(currentItem >= users.size()) {
            currentItem = 0;
            return false;
        }
        return true;
    }

    @Override
    public Object next() {
        return users.get(currentItem++);
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
}
