package cn.org.rapid_framework.generator.provider.db.table.model;

import cn.org.rapid_framework.generator.util.StringHelper;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;

public class ForeignColumn {

	private static final long serialVersionUID = 1568565694691647451L;

	@XStreamAlias("searchable")
	@XStreamAsAttribute
	private boolean searchable = false;
	
	@XStreamAlias("refer")
	@XStreamAsAttribute
	private String refer = null;

	private Column referColumn = null;
	
	private String columnName=null;
	
	@XStreamAlias("align")
	@XStreamAsAttribute
	private String align;
	
	@XStreamAlias("width")
	@XStreamAsAttribute
	private String width;

	@XStreamAlias("ftype")
	@XStreamAsAttribute
	private String ftype;
	
	
	public ForeignColumn() {
		super();
	}

	public ForeignColumn(boolean searchable, String sqlName,
			String columnAlias, String javaType) {
		super();
		this.searchable = searchable;
	}

	public boolean isSearchable() {
		return searchable;
	}

	public void setSearchable(boolean searchable) {
		this.searchable = searchable;
	}

	public boolean isPk() {
		if (referColumn != null) {
			return referColumn.isPk();
		}
		return false;
	}

	public String getSqlName() {
		if (referColumn != null) {
			return referColumn.getSqlName();
		}
		return "";
	}

	public String getColumnAlias() {
		if (referColumn != null) {
			return referColumn.getColumnAlias();
		}
		return "";

	}

	public String getJavaType() {
		if (referColumn != null) {
			return referColumn.getJavaType();
		}
		return "";
	}
	
	public String getColumnNameLower() {
		if(columnName==null) {
			columnName = StringHelper.makeAllWordFirstLetterUpperCase(StringHelper.toUnderscoreName(getSqlName()));
		}
		return StringHelper.uncapitalize(columnName);
	}

	@Override
	public String toString() {
		if (referColumn != null) {
			return (referColumn.getSqlName() + "("
					+ referColumn.getColumnAlias() + ")");
		}
		return this.refer;
	}

	

	public String getRefer() {
		return refer;
	}

	public void setRefer(String refer) {
		this.refer = refer;
	}

	public Column getReferColumn() {
		return referColumn;
	}

	public void setReferColumn(Column referColumn) {
		this.referColumn = referColumn;
	}

	public String getAlign() {
		return align;
	}

	public void setAlign(String align) {
		this.align = align;
	}

	public String getWidth() {
		return width;
	}

	public void setWidth(String width) {
		this.width = width;
	}
	
	public String getFtype() {
		return ftype;
	}

	public void setFtype(String ftype) {
		this.ftype = ftype;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((refer == null) ? 0 : refer.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ForeignColumn other = (ForeignColumn) obj;
		if (refer == null) {
			if (other.refer != null)
				return false;
		} else if (!refer.equals(other.refer))
			return false;
		return true;
	}
	
	

}
