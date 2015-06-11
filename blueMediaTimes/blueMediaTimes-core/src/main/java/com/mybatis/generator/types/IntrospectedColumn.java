package com.mybatis.generator.types;

import org.mybatis.generator.api.dom.java.FullyQualifiedJavaType;

/**
 * Created by huyan on 15/5/6.
 */
public class IntrospectedColumn extends org.mybatis.generator.api.IntrospectedColumn {
    public IntrospectedColumn() {
    }

    public void setFullyQualifiedJavaType(FullyQualifiedJavaType fullyQualifiedJavaType) {
        super.setFullyQualifiedJavaType(fullyQualifiedJavaType);
        if(91 == this.getJdbcType() && "org.joda.time.DateTime".equals(fullyQualifiedJavaType.getFullyQualifiedName())) {
            this.typeHandler = "com.mybatis.typehandler.JodaDateTime2DateTypeHandler";
        } else if(93 == this.getJdbcType() && "org.joda.time.DateTime".equals(fullyQualifiedJavaType.getFullyQualifiedName())) {
            this.typeHandler = "com.mybatis.typehandler.JodaDateTime2TimestampTypeHandler";
        } else if(92 == this.getJdbcType() && "org.joda.time.DateTime".equals(fullyQualifiedJavaType.getFullyQualifiedName())) {
            this.typeHandler = "com.mybatis.typehandler.JodaDateTime2TimeTypeHandler";
        }

    }
}
