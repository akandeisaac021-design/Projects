import java.util.ArrayList;
import java.util.List;

public class Diary {
    private String username;
    private String password;
    private boolean isLocked;
    private List<Entry> entries;

    public Diary(String username, String password) {
        this.username = username;
        this.password = password;
        this.isLocked = false;
        this.entries = new ArrayList<>();
    }

    public void unlockDiary(String password) {
        if (this.password.equals(password)) isLocked = false;
    }

    public void lockDiary() {
        isLocked = true;
    }

    public boolean isLocked() {
        return isLocked;
    }

    public void createEntry(String title, String body) {
        int nextId =entries.size() + 1;
        entries.add(new Entry(nextId, title, body));
    }

    public void deleteEntry(int id) {
        for (int count =0; count <entries.size(); count++) {
            Entry entry = entries.get(count);
            
            if (entry.getId() == id) {
                entries.remove(count);
                break; 
            }
        }
    }


public Entry findEntryById(int id) {
    for (Entry entry :entries) {
        if (entry.getId() == id) {
            return entry;
        }
    }
    return null;
}


    public void updateEntry(int id, String title, String body) {
        Entry entry = findEntryById(id);
        if (entry != null) {
            entry.setTitle(title);
            entry.setBody(body);
        }
    }
}
