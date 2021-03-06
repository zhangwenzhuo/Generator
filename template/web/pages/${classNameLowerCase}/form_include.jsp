<%@page import="${basepackage}.model.*" %>
<#include "/macro.include"/> 
<#assign className = table.className>   
<#assign classNameLower = className?uncap_first>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/commons/taglibs.jsp" %>

<#list table.columns as column>
<#if column.htmlHidden>
	<input type="hidden" id="${column.columnNameLower}" name="${column.columnNameLower}" value="<@jspEl classNameLower+"."+column.columnNameLower/>"/>
</#if>
</#list>

<#list table.columns as column>
	<#if !column.htmlHidden && (!column.noneditable)>	
	<tr>	
		<td class="tdLabel">
			<#if !column.nullable><span class="required">*</span></#if><%=${className}.ALIAS_${column.constantName}%>:
		</td>		
		<td>
	<#if column.isDateTimeColumn>
		<input value="<@jspEl classNameLower+"."+column.columnNameLower+"String"/>" onclick="WdatePicker({dateFmt:'<%=${className}.FORMAT_${column.constantName}%>'})" id="${column.columnNameLower}String" name="${column.columnNameLower}String"  maxlength="0" class="${column.validateString}" />
	
	<#elseif column.defineForeignInfo>
		<yun:button-edit name="${column.buttonEdit.name}" hiddenName="${column.buttonEdit.hiddenName}" id="${column.buttonEdit.id}" txtVal="<@jspEl classNameLower+"."+column.buttonEdit.txtVal/>"  hiddenVal="<@jspEl classNameLower+"."+column.buttonEdit.hiddenVal/>" width="${column.buttonEdit.width}"  profileId="${column.buttonEdit.profileId}"/> 
	
	<#elseif column.enumType>
		<form:select path="${column.columnNameLower}" id="${column.columnNameLower}">
		<#list column.enumListExcludeOtherVal as current>
			<form:option value="${current.enumKey}" >${current.enumDesc}</form:option>
		</#list>
		</form:select>
	<#else>
		<form:input path="${column.columnNameLower}" id="${column.columnNameLower}" cssClass="${column.validateString}" maxlength="${column.size}" />
	</#if>
		<font color='red'><form:errors path="${column.columnNameLower}"/></font>
		</td>
	</tr>	
	
	</#if>
</#list>		