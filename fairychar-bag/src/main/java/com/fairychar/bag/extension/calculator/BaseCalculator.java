package com.fairychar.bag.extension.calculator;


import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * 计算器基类
 *
 * @author chiyo <br>
 * @since
 */
public abstract class BaseCalculator {
    protected boolean calculate(Operate operate, List args, List<String> compareValues, Class dataType) {
        switch (operate) {
            case EQUAL:
                return this.equal(args, compareValues, dataType);
            case NOT_EQUAL:
                return this.notEqual(args, compareValues, dataType);
            case CONTAIN_ALL:
                return this.containAll(args, compareValues, dataType);
            case CONTAIN:
                return this.contain(args, compareValues, dataType);
            case IN:
                return this.in(args, compareValues, dataType);
            case NOT_IN:
                return this.notIn(args, compareValues, dataType);
            case LESS_THAN:
                return this.less(args, compareValues, dataType);
            case LESS_EQUAL:
                return this.lessEqual(args, compareValues, dataType);
            case GREATER_THAN:
                return this.greater(args, compareValues, dataType);
            case GREATER_EQUAL:
                return this.greaterEqual(args, compareValues, dataType);
            case IN_ANY:
                return this.anyIn(args, compareValues, dataType);
            case CONTAIN_ANY:
                return this.containAny(args, compareValues, dataType);
            default:
                return false;
        }
    }

    private boolean containAny(List args, List<String> compareValues, Class dataType) {
        assert args != null && args.size() >= 1;
        assert compareValues != null && compareValues.size() >= 1;
        List<Object> convertValues = compareValues.stream().map(v -> convertValue(v, dataType)).collect(Collectors.toList());
        return args.stream().anyMatch(a -> convertValues.contains(a));
    }

    private boolean anyIn(List args, List<String> compareValues, Class dataType) {
        assert args != null && args.size() >= 1;
        assert compareValues != null && compareValues.size() >= 1;
        List<Object> convertValues = compareValues.stream().map(v -> convertValue(v, dataType)).collect(Collectors.toList());
        return convertValues.stream().anyMatch(v -> args.contains(v));
    }

    private boolean contain(List args, List<String> compareValues, Class dataType) {
        if (args.isEmpty()) {
            return false;
        }
        assert compareValues != null && compareValues.size() >= 1;
        List<Object> convertValues = compareValues.stream().map(v -> convertValue(v, dataType)).collect(Collectors.toList());
        return convertValues.stream().anyMatch(s -> args.contains(s));
    }

    /**
     * 大于等于
     *
     * @param args          比较值
     * @param compareValues 规定值
     * @param dataType      数据类型
     * @return boolean
     */
    protected boolean greaterEqual(List args, List<String> compareValues, Class dataType) {
        assert args != null && args.size() == 1;
        assert compareValues != null && compareValues.size() == 1;
        Object convertValue = this.convertValue(compareValues.get(0), dataType);
        return (((Comparable) args.get(0)).compareTo(convertValue) >= 0 ? true : false);
    }

    /**
     * 大于
     *
     * @param args          比较值
     * @param compareValues 规定值
     * @param dataType      数据类型
     * @return boolean
     */
    protected boolean greater(List args, List<String> compareValues, Class dataType) {
        assert args != null && args.size() == 1;
        assert compareValues != null && compareValues.size() == 1;
        Object convertValue = this.convertValue(compareValues.get(0), dataType);
        return (((Comparable) args.get(0)).compareTo(convertValue) > 0 ? true : false);
    }

    /**
     * 小于等于
     *
     * @param args         比较值
     * @param compareValue 规定值
     * @param dataType     数据类型
     * @return boolean
     */
    protected boolean lessEqual(List args, List<String> compareValue, Class dataType) {
        assert args != null && args.size() == 1;
        assert compareValue != null && compareValue.size() == 1;
        Object convertValue = this.convertValue(compareValue.get(0), dataType);
        return (((Comparable) args.get(0)).compareTo(convertValue) <= 0 ? true : false);
    }

    /**
     * 小于
     *
     * @param args          比较值
     * @param compareValues 规定值
     * @param dataType      数据类型
     * @return boolean
     */
    protected boolean less(List args, List<String> compareValues, Class dataType) {
        assert args != null && args.size() == 1;
        assert compareValues != null && compareValues.size() == 1;
        Object convertValue = this.convertValue(compareValues.get(0), dataType);
        return (((Comparable) args.get(0)).compareTo(convertValue) < 0 ? true : false);
    }

    /**
     * 不在数据集内
     *
     * @param args          比较值
     * @param compareValues 规定值
     * @param dataType      数据类型
     * @return boolean
     */
    protected boolean notIn(List args, List<String> compareValues, Class dataType) {
        assert args != null && args.size() >= 1;
        assert compareValues != null && compareValues.size() >= 1;
        List<Object> convertValues = compareValues.stream().map(v -> convertValue(v, dataType)).collect(Collectors.toList());
        return !convertValues.containsAll(args);
    }

    /**
     * 在数据集内
     *
     * @param args          比较值
     * @param compareValues 规定值
     * @param dataType      数据类型
     * @return boolean
     */
    protected boolean in(List args, List<String> compareValues, Class dataType) {
        assert args != null && args.size() >= 1;
        assert compareValues != null && compareValues.size() >= 1;
        List<Object> convertValues = compareValues.stream().map(v -> convertValue(v, dataType)).collect(Collectors.toList());
        return convertValues.containsAll(args);
    }

    /**
     * 包含所有
     *
     * @param args          比较值
     * @param compareValues 规定值
     * @param dataType      数据类型
     * @return boolean
     */
    protected boolean containAll(List args, List<String> compareValues, Class dataType) {
        assert args != null && args.size() >= 1;
        assert compareValues != null && compareValues.size() >= 1;
        List<Object> convertValues = compareValues.stream().map(v -> convertValue(v, dataType)).collect(Collectors.toList());
        return args.containsAll(convertValues);
    }

    /**
     * 不相等
     *
     * @param args          比较值
     * @param compareValues 规定值
     * @param dataType      数据类型
     * @return boolean
     */
    protected boolean notEqual(List args, List<String> compareValues, Class dataType) {
        assert args != null && args.size() == 1;
        assert compareValues != null && compareValues.size() == 1;
        Object convertValue = this.convertValue(compareValues.get(0), dataType);
        return !Objects.equals(args.get(0), convertValue);
    }

    /**
     * 相等
     *
     * @param args          比较值
     * @param compareValues 规定值
     * @param dataType      数据类型
     * @return boolean
     */
    protected boolean equal(List args, List<String> compareValues, Class dataType) {
        assert args != null && args.size() == 1;
        assert compareValues != null && compareValues.size() == 1;
        Object convertValue = this.convertValue(compareValues.get(0), dataType);
        return Objects.equals(args.get(0), convertValue);
    }


    /**
     * 根据class类型将String转换为对应值
     *
     * @param arg      参数
     * @param dataType 数据类型
     * @return {@link Object}
     */
    private Object convertValue(String arg, Class dataType) {
        if (dataType == Integer.class) {
            return Integer.valueOf(arg);
        } else if (dataType == Double.class) {
            return Double.valueOf(arg);
        } else if (dataType == Boolean.class) {
            return Boolean.valueOf(arg);
        } else if (dataType == String.class) {
            return arg;
        } else {
            throw new RuntimeException("不支持的类型");
        }
    }
}
