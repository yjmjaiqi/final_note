package com.xxzx.final_note.entity;

import lombok.Data;

@Data
public class Note {
    private Integer id;
    private String  note_title;
    private String  note_content;
    private String  note_time;
    private String  alter_time;
    private Integer userid;
    private String shareid;

    public Note() {
    }

    @Override
    public String toString() {
        return "Note{" +
                "id=" + id +
                ", note_title='" + note_title + '\'' +
                ", note_content='" + note_content + '\'' +
                ", note_time='" + note_time + '\'' +
                ", alter_time='" + alter_time + '\'' +
                ", userid=" + userid +
                ", shareid=" + shareid +
                '}';
    }
}
