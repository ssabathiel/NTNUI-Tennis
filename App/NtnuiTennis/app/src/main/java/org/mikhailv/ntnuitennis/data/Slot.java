package org.mikhailv.ntnuitennis.data;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by MikhailV on 06.01.2017.
 */

public interface Slot
{
    String getLink();

    String getAttendLink();

    String getLevel();

    boolean isExpired();

    List<String> getAttending();

    boolean hasAvailable();

    boolean isMeAttending();
}

class SlotImpl implements Slot
{
    private List<String> m_reserved;
    private boolean m_expired;
    private String m_lvl;
    private String m_link;
    private String m_attendLink;

    public SlotImpl()
    {
        m_reserved = new ArrayList<>();
    }
    public String getLink()
    {
        return m_link;
    }
    public SlotImpl setLink(String link)
    {
        m_link = link;
        return this;
    }
    @Override
    public String getAttendLink()
    {
        return m_attendLink;
    }
    public SlotImpl setAttendLink(String link)
    {
        m_attendLink = link;
        return this;
    }
    public String getLevel()
    {
        return m_lvl;
    }
    public SlotImpl setLevel(String lvl)
    {
        m_lvl = lvl;
        return this;
    }
    public boolean isExpired()
    {
        return m_expired;
    }
    public SlotImpl setExpired(boolean expired)
    {
        m_expired = expired;
        return this;
    }
    public List<String> getAttending()
    {
        return m_reserved;
    }
    public SlotImpl addName(String name)
    {
        m_reserved.add(name);
        return this;
    }
    public boolean hasAvailable()
    {
        for (String name : m_reserved)
            if (name == null)
                return true;
        return false;
    }
    public boolean isMeAttending()
    {
        for (String name : m_reserved)
            if (name != null && name.equals(Globals.MY_NAME))
                return true;
        return false;
    }
}
