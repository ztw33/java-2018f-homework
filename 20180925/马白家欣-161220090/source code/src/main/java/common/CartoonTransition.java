package common;

import being.*;

/**
 * @Description 一些CartoonCharacter的转化函数
 * @Author LUCUS BAI
 * @Date 2018/10/23
 */

public class CartoonTransition {

    static final public String ANSI_SUFFIX = "\033[0m";
    static final public String ANSI_PREFIX = "\033[";
    static final public String ROOT_PATH = "/";

    static public String cartoonCharacterToANSI(CartoonCharacter cartoonCharacter) {
        /**
         * @Description 用来将卡通人物转化成ANSI转义字符，用于控制台显示
         * @Author LUCUS BAI
         * @Date 2018/10/23
         * @Parameters [cartoonCharacter]
         * @ReturnValue java.lang.String
         */
        String returnString = "";
        returnString += ANSI_PREFIX;

        if (cartoonCharacter instanceof Red) {
            returnString += "41;30;4m";
        } else if (cartoonCharacter instanceof Orange) {
            returnString += "43;30;4m";
        } else if (cartoonCharacter instanceof Yellow) {
            returnString += "42;30;4m";
        } else if (cartoonCharacter instanceof Green) {
            returnString += "46;30;4m";
        } else if (cartoonCharacter instanceof Cyan) {
            returnString += "44;30;4m";
        } else if (cartoonCharacter instanceof Blue) {
            returnString += "44;30;4m";
        } else if (cartoonCharacter instanceof Purple) {
            returnString += "45;30;4m";
        } else if (cartoonCharacter instanceof Grandfather) {
            returnString += "40;31;4m";
        } else if (cartoonCharacter instanceof Scorpion) {
            returnString += "47;30;4m";
        } else if (cartoonCharacter instanceof Snake) {
            returnString += "47;30;4m";
        } else if (cartoonCharacter instanceof LowLevelDemon) {
            returnString += "47;30;4m";
        } else {
            return " ";
        }

        returnString += cartoonCharacter.getLabel() + ANSI_SUFFIX;

        return returnString;
    }

    static public String cartoonCharacterToImage(CartoonCharacter cartoonCharacter) {

        /**
         * @Description 用来将卡通人物转化成图片资源文件目录，用于GUI显示
         * @Author LUCUS BAI
         * @Date 2018/10/23
         * @Parameters [cartoonCharacter]
         * @ReturnValue java.lang.String
         */

        if (cartoonCharacter instanceof Red) {
            return ROOT_PATH + "Red.jpeg";
        } else if (cartoonCharacter instanceof Orange) {
            return ROOT_PATH + "Orange.jpeg";
        } else if (cartoonCharacter instanceof Yellow) {
            return ROOT_PATH + "Yellow.jpeg";
        } else if (cartoonCharacter instanceof Green) {
            return ROOT_PATH + "Green.jpeg";
        } else if (cartoonCharacter instanceof Cyan) {
            return ROOT_PATH + "Cyan.jpeg";
        } else if (cartoonCharacter instanceof Blue) {
            return ROOT_PATH + "Blue.jpeg";
        } else if (cartoonCharacter instanceof Purple) {
            return ROOT_PATH + "Purple.jpeg";
        } else if (cartoonCharacter instanceof Grandfather) {
            return ROOT_PATH + "GrandFather.jpeg";
        } else if (cartoonCharacter instanceof Scorpion) {
            return ROOT_PATH + "Scorpion.jpeg";
        } else if (cartoonCharacter instanceof Snake) {
            return ROOT_PATH + "Snake.jpeg";
        } else if (cartoonCharacter instanceof LowLevelDemon) {
            return ROOT_PATH + "LowLevel.jpeg";
        } else {
            return "";
        }
    }
}

