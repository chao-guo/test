package chao.sqlParser;

/** *//**
*
* 单句查询语句解析器
* @author 赵朝峰
*
* @since 2013-6-10
* @version 1.00
*/
public class SelectSqlParser extends BaseSingleSqlParser{
public SelectSqlParser(String originalSql) {
    super(originalSql);
}
@Override
protected void initializeSegments() {
    segments.add(new SqlSegment("(select)(.+)(from)","[,]"));
    segments.add(new SqlSegment("(from)(.+)( where | on | having | group by | order by | ENDOFSQL)","(,| left join | right join | inner join )"));
    segments.add(new SqlSegment("(where|on|having)(.+)( group by | order by | ENDOFSQL)","(and|or)"));
    segments.add(new SqlSegment("(group by)(.+)( order by| ENDOFSQL)","[,]"));
    segments.add(new SqlSegment("(order by)(.+)( ENDOFSQL)","[,]"));
}
}