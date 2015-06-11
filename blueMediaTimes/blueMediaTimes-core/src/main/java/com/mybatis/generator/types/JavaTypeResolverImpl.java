package com.mybatis.generator.types;

import org.joda.time.DateTime;
import org.mybatis.generator.api.IntrospectedColumn;
import org.mybatis.generator.api.JavaTypeResolver;
import org.mybatis.generator.api.dom.java.FullyQualifiedJavaType;
import org.mybatis.generator.config.Context;
import org.mybatis.generator.internal.util.StringUtility;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

/**
 * Created by huyan on 15/5/6.
 */
public class JavaTypeResolverImpl implements JavaTypeResolver {
    protected List<String> warnings;
    protected Properties properties = new Properties();
    protected Context context;
    protected boolean forceBigDecimals;
    protected Map<Integer, JdbcTypeInformation> typeMap = new HashMap();
    static final int NVARCHAR = -9;
    static final int NCHAR = -15;
    static final int NCLOB = 2011;

    public JavaTypeResolverImpl() {
        this.typeMap.put(Integer.valueOf(2003), new JavaTypeResolverImpl.JdbcTypeInformation("ARRAY", new FullyQualifiedJavaType(Object.class.getName())));
        this.typeMap.put(Integer.valueOf(-5), new JavaTypeResolverImpl.JdbcTypeInformation("BIGINT", new FullyQualifiedJavaType(Long.class.getName())));
        this.typeMap.put(Integer.valueOf(-2), new JavaTypeResolverImpl.JdbcTypeInformation("BINARY", new FullyQualifiedJavaType("byte[]")));
        this.typeMap.put(Integer.valueOf(-7), new JavaTypeResolverImpl.JdbcTypeInformation("BIT", new FullyQualifiedJavaType(Boolean.class.getName())));
        this.typeMap.put(Integer.valueOf(2004), new JavaTypeResolverImpl.JdbcTypeInformation("BLOB", new FullyQualifiedJavaType("byte[]")));
        this.typeMap.put(Integer.valueOf(16), new JavaTypeResolverImpl.JdbcTypeInformation("BOOLEAN", new FullyQualifiedJavaType(Boolean.class.getName())));
        this.typeMap.put(Integer.valueOf(1), new JavaTypeResolverImpl.JdbcTypeInformation("CHAR", new FullyQualifiedJavaType(String.class.getName())));
        this.typeMap.put(Integer.valueOf(2005), new JavaTypeResolverImpl.JdbcTypeInformation("CLOB", new FullyQualifiedJavaType(String.class.getName())));
        this.typeMap.put(Integer.valueOf(70), new JavaTypeResolverImpl.JdbcTypeInformation("DATALINK", new FullyQualifiedJavaType(Object.class.getName())));
        this.typeMap.put(Integer.valueOf(2001), new JavaTypeResolverImpl.JdbcTypeInformation("DISTINCT", new FullyQualifiedJavaType(Object.class.getName())));
        this.typeMap.put(Integer.valueOf(8), new JavaTypeResolverImpl.JdbcTypeInformation("DOUBLE", new FullyQualifiedJavaType(Double.class.getName())));
        this.typeMap.put(Integer.valueOf(6), new JavaTypeResolverImpl.JdbcTypeInformation("FLOAT", new FullyQualifiedJavaType(Double.class.getName())));
        this.typeMap.put(Integer.valueOf(4), new JavaTypeResolverImpl.JdbcTypeInformation("INTEGER", new FullyQualifiedJavaType(Integer.class.getName())));
        this.typeMap.put(Integer.valueOf(2000), new JavaTypeResolverImpl.JdbcTypeInformation("JAVA_OBJECT", new FullyQualifiedJavaType(Object.class.getName())));
        this.typeMap.put(Integer.valueOf(-4), new JavaTypeResolverImpl.JdbcTypeInformation("LONGVARBINARY", new FullyQualifiedJavaType("byte[]")));
        this.typeMap.put(Integer.valueOf(-1), new JavaTypeResolverImpl.JdbcTypeInformation("LONGVARCHAR", new FullyQualifiedJavaType(String.class.getName())));
        this.typeMap.put(Integer.valueOf(-15), new JavaTypeResolverImpl.JdbcTypeInformation("NCHAR", new FullyQualifiedJavaType(String.class.getName())));
        this.typeMap.put(Integer.valueOf(2011), new JavaTypeResolverImpl.JdbcTypeInformation("NCLOB", new FullyQualifiedJavaType(String.class.getName())));
        this.typeMap.put(Integer.valueOf(-9), new JavaTypeResolverImpl.JdbcTypeInformation("NVARCHAR", new FullyQualifiedJavaType(String.class.getName())));
        this.typeMap.put(Integer.valueOf(0), new JavaTypeResolverImpl.JdbcTypeInformation("NULL", new FullyQualifiedJavaType(Object.class.getName())));
        this.typeMap.put(Integer.valueOf(1111), new JavaTypeResolverImpl.JdbcTypeInformation("OTHER", new FullyQualifiedJavaType(Object.class.getName())));
        this.typeMap.put(Integer.valueOf(7), new JavaTypeResolverImpl.JdbcTypeInformation("REAL", new FullyQualifiedJavaType(Float.class.getName())));
        this.typeMap.put(Integer.valueOf(2006), new JavaTypeResolverImpl.JdbcTypeInformation("REF", new FullyQualifiedJavaType(Object.class.getName())));
        this.typeMap.put(Integer.valueOf(5), new JavaTypeResolverImpl.JdbcTypeInformation("SMALLINT", new FullyQualifiedJavaType(Short.class.getName())));
        this.typeMap.put(Integer.valueOf(2002), new JavaTypeResolverImpl.JdbcTypeInformation("STRUCT", new FullyQualifiedJavaType(Object.class.getName())));
        this.typeMap.put(Integer.valueOf(-6), new JavaTypeResolverImpl.JdbcTypeInformation("TINYINT", new FullyQualifiedJavaType(Byte.class.getName())));
        this.typeMap.put(Integer.valueOf(-3), new JavaTypeResolverImpl.JdbcTypeInformation("VARBINARY", new FullyQualifiedJavaType("byte[]")));
        this.typeMap.put(Integer.valueOf(12), new JavaTypeResolverImpl.JdbcTypeInformation("VARCHAR", new FullyQualifiedJavaType(String.class.getName())));
        this.typeMap.put(Integer.valueOf(91), new JavaTypeResolverImpl.JdbcTypeInformation("DATE", new FullyQualifiedJavaType(DateTime.class.getName())));
        this.typeMap.put(Integer.valueOf(92), new JavaTypeResolverImpl.JdbcTypeInformation("TIME", new FullyQualifiedJavaType(DateTime.class.getName())));
        this.typeMap.put(Integer.valueOf(93), new JavaTypeResolverImpl.JdbcTypeInformation("TIMESTAMP", new FullyQualifiedJavaType(DateTime.class.getName())));
    }

    @Override
    public void addConfigurationProperties(Properties properties) {
        this.properties.putAll(properties);
        this.forceBigDecimals = StringUtility.isTrue(properties.getProperty("forceBigDecimals"));
    }

    @Override
    public FullyQualifiedJavaType calculateJavaType(IntrospectedColumn introspectedColumn) {
        JavaTypeResolverImpl.JdbcTypeInformation jdbcTypeInformation = (JavaTypeResolverImpl.JdbcTypeInformation)this.typeMap.get(Integer.valueOf(introspectedColumn.getJdbcType()));
        FullyQualifiedJavaType answer;
        if(jdbcTypeInformation == null) {
            switch(introspectedColumn.getJdbcType()) {
                case 2:
                case 3:
                    if(introspectedColumn.getScale() <= 0 && introspectedColumn.getLength() <= 18 && !this.forceBigDecimals) {
                        if(introspectedColumn.getLength() > 9) {
                            answer = new FullyQualifiedJavaType(Long.class.getName());
                        } else if(introspectedColumn.getLength() > 4) {
                            answer = new FullyQualifiedJavaType(Integer.class.getName());
                        } else {
                            answer = new FullyQualifiedJavaType(Short.class.getName());
                        }
                    } else {
                        answer = new FullyQualifiedJavaType(BigDecimal.class.getName());
                    }
                    break;
                default:
                    answer = null;
            }
        } else {
            answer = jdbcTypeInformation.getFullyQualifiedJavaType();
        }

        return answer;
    }

    @Override
    public String calculateJdbcTypeName(IntrospectedColumn introspectedColumn) {
        JavaTypeResolverImpl.JdbcTypeInformation jdbcTypeInformation = (JavaTypeResolverImpl.JdbcTypeInformation)this.typeMap.get(Integer.valueOf(introspectedColumn.getJdbcType()));
        String answer;
        if(jdbcTypeInformation == null) {
            switch(introspectedColumn.getJdbcType()) {
                case 2:
                    answer = "NUMERIC";
                    break;
                case 3:
                    answer = "DECIMAL";
                    break;
                default:
                    answer = null;
            }
        } else {
            answer = jdbcTypeInformation.getJdbcTypeName();
        }

        return answer;
    }

    @Override
    public void setWarnings(List<String> warnings) {
        this.warnings = warnings;
    }

    @Override
    public void setContext(Context context) {
        this.context = context;
    }

    protected static class JdbcTypeInformation {
        private String jdbcTypeName;
        private FullyQualifiedJavaType fullyQualifiedJavaType;

        public JdbcTypeInformation(String jdbcTypeName, FullyQualifiedJavaType fullyQualifiedJavaType) {
            this.jdbcTypeName = jdbcTypeName;
            this.fullyQualifiedJavaType = fullyQualifiedJavaType;
        }

        public String getJdbcTypeName() {
            return this.jdbcTypeName;
        }

        public FullyQualifiedJavaType getFullyQualifiedJavaType() {
            return this.fullyQualifiedJavaType;
        }
    }
}
