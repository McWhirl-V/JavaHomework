package cn.mcwhirl.chapter.chapter2.work2;

import cn.mcwhirl.utils.Tool;

public class Wrapper {
    private final Tool tool = new Tool();
    public void wrapperNum(){
        System.out.println("byte的数据总数： " + Math.pow(2,Byte.SIZE));
        System.out.println("byte的取值范围： " + Byte.MIN_VALUE +"~"+Byte.MAX_VALUE);
        System.out.println("将字符串127转换为byte类型： " + Byte.parseByte("127"));

        System.out.println("\nint的数据总数： " + Math.pow(2,Integer.SIZE));
        System.out.println("int的取值范围" + Integer.MIN_VALUE+"~"+Integer.MAX_VALUE);
        System.out.println("将字符串50000转换为int类型： "+ Integer.parseInt("50000"));
        System.out.println("16转换为2进制： "+ Integer.toBinaryString(16));
        System.out.println("16转换为16进制： "+ Integer.toHexString(16));

        System.out.println("展示完毕，输入任意键返回...");
        tool.inputInt();

    }
}
