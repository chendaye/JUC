package Algorithm.Interview.NowCoder;

/**
 * 请实现一个函数用来判断字符串是否表示数值（包括整数和小数）。例如，字符串"+100","5e2","-123","3.1416"和"-1E-16"都表示数值。
 * 但是"12e","1a3.14","1.2.3","+-5"和"12e+4.3"都不是。
 *
 * todo: 常用正则
 *          - $ 匹配输入字符串的结尾位置
 *          - ^ 开始位置
 *          - ( ) 标记一个子表达式的开始和结束位置。子表达式可以获取供以后使用
 *          - *  0~无穷
 *          - +  1~无穷
 *          - .  匹配除换行符 \n 之外的任何单字符
 *          - + 0~1
 *          - | 指明两项之间的一个选择
 *          - {n} 匹配确定的 n 次
 *          - {n,}  至少匹配n 次
 *          - {n,m}  最少匹配 n 次且最多匹配 m 次
 *          - x|y   匹配 x 或 y
 *          - [xyz]  匹配所包含的任意一个字符
 *          - [^xyz]  匹配未包含的任意字符
 *          - [a-z]  匹配指定范围内的任意字符
 *          - [^a-z]  匹配任何不在指定范围内的任意字符
 *          - \b  匹配一个单词边界，也就是指单词和空格间的位置
 *          - \B  匹配非单词边界
 *          - \d  匹配一个数字字符。等价于 [0-9]。
 *          - \D  匹配一个非数字字符。等价于 [^0-9]。
 *          - \n  匹配一个换行符
 *          - \r  匹配一个回车符
 *          - \s  匹配任何空白字符，包括空格、制表符、换页符等等。等价于 [ \f\n\r\t\v]
 *          - \S  匹配任何非空白字符。等价于 [^ \f\n\r\t\v]。
 *          - \t  匹配一个制表符
 *          - \v  匹配一个垂直制表符
 *          - \w   匹配字母、数字、下划线。等价于'[A-Za-z0-9_]'。
 *          - \W  匹配非字母、数字、下划线。等价于 '[^A-Za-z0-9_]'
 */
public class isNumeric {
    public boolean isNumeric(char[] str) {
        String s=String.valueOf(str);
        return s.matches("[\\+\\-]?(\\d*\\.\\d+|\\d+\\.?)([eE][\\+\\-]?\\d+)?");
    }

    public static void main(String[] args) {

    }
}
