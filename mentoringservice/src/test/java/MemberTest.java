import com.codeclan.mentoring.mentoringservice.models.Member;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MemberTest {
    Member dave;

    @Before
    public void setUp() {
        dave = new Member("Dave McKenzie", "I am a Product Owner with an extensive background in QA testing", "/in/dave-mckenzie/");
    }

    @Test
    public void memberHasAName() {
        assertEquals("Dave McKenzie", dave.getName());
    }

    @Test
    public void canUpdateMemberName() {
        dave.setName("Neil");
        assertEquals("Neil", dave.getName());
    }

    @Test
    public void memberHasABio() {
        assertEquals("I am a Product Owner with an extensive background in QA testing", dave.getBio());
    }

    @Test
    public void canUpdateBio() {
        dave.setBio("Product Owner");
        assertEquals("Product Owner", dave.getBio());
    }

    @Test
    public void memberHasALinkedInLink() {
        assertEquals("/in/dave-mckenzie/", dave.getLinkedIn());
    }

    @Test
    public void canUpdateLinkedIn() {
        dave.setLinkedIn("/in/neil-mckenzie");
        assertEquals("/in/neil-mckenzie", dave.getLinkedIn());
    }
}
