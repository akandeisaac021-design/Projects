import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class DiaryTest {
    private Diary diary;

    @BeforeEach
    void setUp() {
        diary = new Diary("testUser", "password123");
    }

    @Test
    void testDiaryIsInitiallyUnlocked() {
        assertFalse(diary.isLocked());
    }

    @Test
    void testLockAndUnlock() {
        diary.lockDiary();
        assertTrue(diary.isLocked());

        diary.unlockDiary("password123");
        assertFalse(diary.isLocked());
    }

    @Test
    void testUnlockWithWrongPasswordDoesNothing() {
        diary.lockDiary();
        diary.unlockDiary("wrong_password");
        assertTrue(diary.isLocked());
    }

    @Test
    void testCreateAndFindEntry() {
        diary.createEntry("First Title", "First Body");
        Entry entry = diary.findEntryById(1);
        
        assertNotNull(entry);
        assertEquals("First Title", entry.getTitle());
        assertEquals("First Body", entry.getBody());
    }

    @Test
    void testUpdateEntry() {
        diary.createEntry("Old Title", "Old Body");
        diary.updateEntry(1, "New Title", "New Body");
        
        Entry updated = diary.findEntryById(1);
        assertEquals("New Title", updated.getTitle());
        assertEquals("New Body", updated.getBody());
    }

    @Test
    void testDeleteEntry() {
        diary.createEntry("Delete Me", "Content");
        assertNotNull(diary.findEntryById(1));
        
        diary.deleteEntry(1);
        assertNull(diary.findEntryById(1));
    }
}

