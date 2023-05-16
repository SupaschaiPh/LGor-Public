/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

/**
 *
 * @author supaschai
 */
import java.util.HashMap;

public class AllTitle {

    public static HashMap<String, String> title = new HashMap();

    static {
        title.put("Clear All", "ล้างทั้งหมด");
        title.put("Custom", "กำหนดเพิ่ม");
        title.put("Add Variable", "เพิ่มตัวแปร");
        title.put("View Custom", "ดูคำสั่งที่กำหนดเอง");
        title.put("VariableName", "ชื่อตัวแปร");
        title.put("Add", "เพิ่ม");
        title.put("This variable was existed", "ชื่อตัวแปรนี้มีอยู่แล้ว");
        title.put("This variable name must not null", "ชื่อตัวแปรห้ามเป็นค่าว่าง");
        title.put("Variable name can not cosits of \" \"", "ชื่อตัวแปรห้ามมีช่องวาง");
        title.put("Variable name must be A-Z , a-z or _ only", "ชื่อตัวแปรต้องประกอบด้วย A-Z , a-z หรือ _ เท่านั้น");
        title.put("Variable name can not be or start with", "ชื่อตัวแปรห้ามประกอบไปด้วย");
        title.put("New Coutsome Var Please add before", "ต้องสร้างตัวแปรก่อน");
        title.put("Accept Integer", "รับตัวเลขจำนวนเต็มเท่านั้น");
        title.put("Condition Only Use with [if, for]", "เงื่อนไขใช้ได้กับ [if, for] เท่านั้น");
        title.put("CountItem", "จำนวนไอเทม");
        title.put("Alive", "สถานะจอนนี่");
        title.put("Alivetrue", "ยังคงชีพ");
        title.put("Alivefalse", "สิ้นชีพตักษัย");
        title.put("Description", "คำอธิบาย");
        title.put("Problem by", "โจทย์โดย");
        title.put("Problem", "โจทย์ที่");
        title.put("Count must keep item", "จำนวนไอเทมที่ต้องเก็บทั้งหมด");
        title.put("Rank", "ระดับความยาก");
        title.put("Easy", "ง่าย");
        title.put("Med", "กลาง");
        title.put("Hard", "ยาก");
        title.put("Problem Name", "ชื่อโจทย์");
        title.put("Author", "ผู้สร้างโจทย์");
        title.put("Limit count command can use", "จำนวนคำสั่งที่ใช้ได้");
        title.put("Status", "สถานะ");
        title.put("SolveProblem", "แก้ปัญหา");
        title.put("Passed", "ผ่าน");
        title.put("Not Passed", "ยังไม่ผ่าน");
        title.put("Not found", "ไม่พบ");//Not found
        title.put("Want to restart?", "ต้องการเริ่มใหม่ไหม");//Want to restart?
        title.put("You Die", "ตุยแล้วเรียบร้อย");//Want to restart?
        title.put("Don't Met Cow", "ไม่เจอวัวอ่ะ");//Want to restart?
        title.put("Item not equal request, You got", "ได้ไอเทมไม่ครบตามที่กำหนด, ได้มาแค่");
        title.put("Met Cow, You passed", "เจอวัวแล้ว, ผ่านได้");
        title.put("Start", "เริ่ม");
        title.put("Tutorial", "ทดลองเล่น");
        title.put("MyScore", "คะแนนของฉัน");
        title.put("Accept Integer Only", "รับตัวเลขจำนวนเต็มเท่านั้น");

    }

    public static String lableList[] = {"Pointer Control", "Command", "Condition"};
    public static String commandList[] = {
        "goUp()", "goDown()", "goLeft()", "goRight()",
        "if->", "else", "end if", "end else",
        "for->", "end for", "keep()", "Del"
    };
    public static String conditionList[] = {
        "meetItem", "meetBarrier", "Del"
    };
    public static String stackCode_head[] = {
        "command", "condition", "pointer"
    };
    public static String resitWord[] = {"set", "if", "else", "for", "end", "go", "keep", "del", "meetCoin", "meetBarrier", "to"};
    public static String customCList[] = {
        "set %s to [int]", "%s+=[int]", "%s-=[int]", "%s==[int]",
        "%s>[int]", "%s>=[int]", "%s<[int]", "%s<=[int]"
    };
}
