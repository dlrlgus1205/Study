/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.5.37
 * Generated at: 2024-02-19 00:32:46 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.view;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import notice.vo.NoticeVO;
import reply.vo.ReplyVO;
import com.google.gson.Gson;
import img.vo.ImgVO;
import java.util.List;

public final class noticedetail_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = new java.util.HashSet<>();
    _jspx_imports_classes.add("java.util.List");
    _jspx_imports_classes.add("notice.vo.NoticeVO");
    _jspx_imports_classes.add("com.google.gson.Gson");
    _jspx_imports_classes.add("reply.vo.ReplyVO");
    _jspx_imports_classes.add("img.vo.ImgVO");
  }

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
      throws java.io.IOException, javax.servlet.ServletException {

    final java.lang.String _jspx_method = request.getMethod();
    if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method) && !javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSPs only permit GET POST or HEAD");
      return;
    }

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html lang=\"en\">\r\n");
      out.write("<head>\r\n");
      out.write("<meta charset=\"UTF-8\">\r\n");
      out.write("<meta name=\"viewport\"\r\n");
      out.write("\tcontent=\"width=device-width, initial-scale=1, shrink-to-fit=no\" />\r\n");
      out.write("<meta name=\"description\" content=\"\" />\r\n");
      out.write("<meta name=\"author\" content=\"\" />\r\n");
      out.write("<title>Insert title here</title>\r\n");
      out.write("<script type=\"text/javascript\"\r\n");
      out.write("\tsrc=\"");
      out.print(request.getContextPath());
      out.write("/js/jquery-3.7.1.min.js\"></script>\r\n");
      out.write("<link rel=\"icon\" type=\"image/x-icon\" href=\"assets/favicon.ico\" />\r\n");
      out.write("<script src=\"https://use.fontawesome.com/releases/v5.15.3/js/all.js\"\r\n");
      out.write("\tcrossorigin=\"anonymous\"></script>\r\n");
      out.write("<link href=\"");
      out.print(request.getContextPath());
      out.write("/css/styles.css\"\r\n");
      out.write("\trel=\"stylesheet\" />\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("\t\r\n");
      out.write("\t\r\n");
      out.write("\t\r\n");
      out.write("\t");

	NoticeVO vo = (NoticeVO)request.getAttribute("notice");
	
	
	 String ss = null;
	 
	 Gson gson = new Gson();
	 if(vo !=null) ss =gson.toJson(vo);
	 
	 
	 /* { "post_no" : 110   } */
	
      out.write("\r\n");
      out.write("\t function replyDelete(){\r\n");
      out.write("\t\t $(p_cotent).parents(\".p-body\").remove();\r\n");
      out.write("\t\t \r\n");
      out.write("\t\t\r\n");
      out.write("\t }\r\n");
      out.write("\t//modifycontent\r\n");
      out.write("\t function replyReset() {\r\n");
      out.write("\t\tp_content = $(\"#modifyform\").parent();\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t$(\"body\").append($(\"#modifyform\"));\r\n");
      out.write("\t\t$(\"#modifyform\").hide();\r\n");
      out.write("\t\t\r\n");
      out.write("\t\tlet replyno = sessionStorage.getItem(\"replyno\");\r\n");
      out.write("\t\tconsole.log(\"replyno : \" + replyno);\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t$(\"#spn\"+replyno).css(\"display\",\"block\");\r\n");
      out.write("\t\t\r\n");
      out.write("// \t\t$(p_content).html(reply_content);\r\n");
      out.write("\t}\r\n");
      out.write("\t \r\n");
      out.write("\t function replyUpdate(){\r\n");
      out.write("\t\t //p_content = $(\"#modifyform\").parent();\r\n");
      out.write("\t\t//\treplyNo =pvo.reply_no;\r\n");
      out.write("\t\t $.ajax({\r\n");
      out.write("\t\t\t url :\"");
      out.print( request.getContextPath());
      out.write("/replyUpdate.do\",\r\n");
      out.write("\t\t\t method : \"POST\",\r\n");
      out.write("\t\t\t data : {\"replyno\" : vidx, \"replycontent\" : modifycontent},\r\n");
      out.write("\t\t\t success : function(res){\r\n");
      out.write("\t\t\t\t //alert(\"성공\");\r\n");
      out.write("\t\t\t\t reply_content.html(modiout);\r\n");
      out.write("\t\t\t\t \r\n");
      out.write("\t\t\t\t today= new Date();\r\n");
      out.write("\t\t\t\t today= today.toLocaleString()\r\n");
      out.write("\t\t\t\t vdate.html(today);\r\n");
      out.write("\t\t\t\t \r\n");
      out.write("\t\t\t },\r\n");
      out.write("\t\t\t error : function(xhr){\r\n");
      out.write("\t\t\t\t alert(\"상태 :\" +xhr.status);\r\n");
      out.write("\t\t\t },\r\n");
      out.write("\t\t\t dataType : \"JSON\"\r\n");
      out.write("\t\t })\r\n");
      out.write("\t\t \r\n");
      out.write("\t }\r\n");
      out.write("\t \r\n");
      out.write("\t \r\n");
      out.write("\t function replyList(){\r\n");
      out.write("\t\t\tnoticeNo =nvo.notice_no;\r\n");
      out.write("\t\t\ttarget = this;\r\n");
      out.write("\t\t\t$.ajax({\r\n");
      out.write("\t\t\t\turl :\"");
      out.print( request.getContextPath());
      out.write("/replyList.do\",\r\n");
      out.write("\t\t\t\tmethod : \"GET\",\r\n");
      out.write("\t\t\t\tdata : {\"noticeno\" : nvo.notice_no},\r\n");
      out.write("\t\t\t\tsuccess : function(res){\r\n");
      out.write("\t\t\t\t\tconsole.log(res);\r\n");
      out.write("\t\t\t\t\t//출력 \r\n");
      out.write("\t\t\t\t\tparent = $(target).parents('.my4');\r\n");
      out.write("\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\trcode = \"\";\r\n");
      out.write("\t\t\t\t\t$.each(res, function(i, v){\r\n");
      out.write("\t\t\t\t\t\tcont = v.cont;\r\n");
      out.write("\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\trcode += `<div class = \"reply-body\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<div class = \"p-body\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<p class = \"p-head\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t작성자 : <span>${v.mem_name}</span><br>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t날짜 : <span class=\"sda\">${v.reply_write_date}<span><br>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t내  용 : \r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t<p class = \"p-content\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t<span id=\"spn${v.reply_no}\">${v.reply_content}</span>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t</p><br>`\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\trcode += `<input idx=\"${v.reply_no}\" type=\"button\" value=\"댓글 수정\" data-replyno=\"${v.reply_no}\" name = \"r-modify\" class=\"action action-first r_modify\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t<input idx=\"${v.reply_no}\" type=\"button\" value=\"댓글 삭제\" data-replyno=\"${v.reply_no}\" name = \"r-delete\" class=\"action r_delete\">`\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\trcode += `</p>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t  </div><br> `\r\n");
      out.write("\t\t\t\t\t});\r\n");
      out.write("\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t$(\"#replyView\").html(rcode);\r\n");
      out.write("\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\r\n");
      out.write("\t\t\t\t},\r\n");
      out.write("\t\t\t\terror : function(xhr){\r\n");
      out.write("\t\t\t\t\talert(\"상태 :\" + xhr.status);\r\n");
      out.write("\t\t\t\t},\r\n");
      out.write("\t\t\t\tdataType : \"JSON\"\r\n");
      out.write("\t\t\t})\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t} \r\n");
      out.write("\t reply={ };\r\n");
      out.write("\t$(document).ready(function(){\r\n");
      out.write("\t\tnvo = ");
      out.print( ss);
      out.write(";\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t\r\n");
      out.write("\t\tconsole.log(\"post_no ==============\" , nvo.notice_no);\r\n");
      out.write("\t\t\r\n");
      out.write("\t\treplyList();\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t//댓글 삭제\r\n");
      out.write("\t\t$(document).on(\"click\",\".r_delete\", function(){\r\n");
      out.write("\t    \tlet replyno= $(this).data(\"replyno\");\r\n");
      out.write("\t    \tsessionStorage.setItem(\"replyno\", replyno);\r\n");
      out.write("\t    \t\r\n");
      out.write("\t    \tconsole.log(\"replyno : \" + replyno);\r\n");
      out.write("\t    \t\r\n");
      out.write("\t    \t//댓글 삭제\r\n");
      out.write("\t    \t$(this).parent().parent().next().remove();//br 삭제\r\n");
      out.write("\t    \t$(this).parent().parent().remove();\r\n");
      out.write("\t    \t\r\n");
      out.write("\t    \t $.ajax({\r\n");
      out.write("\t\t\t\t url : \"");
      out.print( request.getContextPath());
      out.write("/replyDelete.do\",\r\n");
      out.write("\t\t\t\t method : \"GET\",\r\n");
      out.write("\t\t\t\t data : {\"replyno\" : replyno},\r\n");
      out.write("\t\t\t\t success :function(res){\r\n");
      out.write("\t\t\t\t\t alert(\"성공\")\r\n");
      out.write("// \t\t\t\t\t $(p_cotent).parents(\".p-body\").remove();\r\n");
      out.write("\t\t\t\t },\r\n");
      out.write("\t\t\t\t error : function(xhr){\r\n");
      out.write("\t\t\t\t\t alert(\"상태 :\" + xhr.status)\r\n");
      out.write("\t\t\t\t },\r\n");
      out.write("\t\t\t\t dataType : \"JSON\"\r\n");
      out.write("\t\t\t\t \r\n");
      out.write("\t\t\t\t \r\n");
      out.write("\t\t\t });\r\n");
      out.write("\t    });\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t$('#resend').on('click', function(){\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t  rcont = $('#replycontent').val();\r\n");
      out.write("\t\t\t  rno = $('#replyno').val();\r\n");
      out.write("\t\t\t  \r\n");
      out.write("\t\t\t  console.log(rcont, rno);\r\n");
      out.write("\t\t\t  \r\n");
      out.write("\t\t\t  $.ajax({\r\n");
      out.write("\t\t\t\t   url : \"");
      out.print(  request.getContextPath());
      out.write("/replyInsert.do\",\r\n");
      out.write("\t\t\t\t   method : \"post\",\r\n");
      out.write("\t\t\t\t   data : {\"replyno\" : rno,  \"replycontent\" : rcont},\r\n");
      out.write("\t\t\t\t   success : function(res){\r\n");
      out.write("\t\t\t\t\t // replyList();\r\n");
      out.write("\t\t\t\t\t  //alert(\"성공\") \r\n");
      out.write("\t\t\t\t\t   //성공했으면 replyList.do를 실행 할 수 이쓴 함 수 \r\n");
      out.write("\t\t\t\t\t  replyList();\r\n");
      out.write("\t\t\t\t   },\r\n");
      out.write("\t\t\t\t   error : function(xhr){\r\n");
      out.write("\t\t\t\t\t   alert(\"상태:\"+  xhr.satus);\r\n");
      out.write("\t\t\t\t   },\r\n");
      out.write("\t\t\t\t   dataType :\"JSON\"\r\n");
      out.write("\t\t\t  })\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t})\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t$(\"#btnUpdate\").on(\"click\",function(){\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\tvar noticeNo = nvo.notice_no;\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\tlocation.href=\"");
      out.print(request.getContextPath());
      out.write("/noticeUpdate.do?notice_no=\" + noticeNo;\r\n");
      out.write("\t\t\t");
      out.write("\r\n");
      out.write("\t\t})\r\n");
      out.write("\t\t\t$(\"#btnDelete\").on(\"click\", function(){\r\n");
      out.write("\t\t\t\tvar noticeNo =  nvo.notice_no;\r\n");
      out.write("\t\t\t\tlocation.href=\"");
      out.print(request.getContextPath());
      out.write("/noticeDelete.do?notice_no=\" + noticeNo;\r\n");
      out.write("\t\t\t\t");
      out.write("\r\n");
      out.write("\t\t\t}) \r\n");
      out.write("\t\t\t$(\"#btnList\").on(\"click\", function(){\r\n");
      out.write("\t\t\t\tvar noticeNo =  notice.notice_no;\r\n");
      out.write("\t\t\t\tlocation.href=\"");
      out.print(request.getContextPath());
      out.write("/noticeList.do?notice_no=\" + noticeNo;\r\n");
      out.write("\t\t\t\tvar replyNo = $(this).attr(\"idx\");\r\n");
      out.write("\t\t\t\tname_attr = $(this).attr('name');\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t})\r\n");
      out.write("\t\t\t$(document).on(\"click\", \".r_modify\", function(){\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t\tlet replyno = $(this).data(\"replyno\");\r\n");
      out.write("\t\t\t\t//수정 대상 번호\r\n");
      out.write("\t\t\t    sessionStorage.setItem(\"replyno\",replyno);\r\n");
      out.write("\t\t\t\tconsole.log(\"replyno : \" + replyno);\r\n");
      out.write("\t\t\t\t$(\"#spn\"+replyno).css(\"display\",\"none\");\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t    if($(\"#modifyform\").css(\"display\") != \"none\"){\r\n");
      out.write("\t\t\t      \r\n");
      out.write("\t\t\t    }\r\n");
      out.write("\t\t\t    \r\n");
      out.write("\t\t\t    //댓글 번호 필요 \r\n");
      out.write("\t\t\t   vidx =  $(this).attr('idx');\r\n");
      out.write("\t\t\t    \r\n");
      out.write("\t\t\t    var reply_content = $(this).closest(\".p-body\").find(\".p-content\"); // 댓글을 쓰는 부눈 수정된 부분\r\n");
      out.write("\t\t\t   \r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t    var modifycontent = $(reply_content).text().trim();//원본글\r\n");
      out.write("\t\t\t    \r\n");
      out.write("\t\t\t    var modifycontent_replace = modifycontent.replace(/<br>/g, \"\\n\"); // 수정된 부분\r\n");
      out.write("\t\t\t    \r\n");
      out.write("\t\t\t    $(\"#modifyform textarea\").val(modifycontent_replace);\r\n");
      out.write("\t\t\t    $(reply_content).append($(\"#modifyform\")); // 수정된 부분\r\n");
      out.write("\t\t\t    $(\"#modifyform\").show();\r\n");
      out.write("\t\t\t});\r\n");
      out.write("\t\t\t$(\"#btnok\").on(\"click\", function(){\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t\tvdate = $(this).parents('.p-body').find('.sda')\r\n");
      out.write("\t\t\t\t//수정 입력 한 댓글\r\n");
      out.write("\t\t\t\tmodifycontent = $(this).prev().val()\r\n");
      out.write("\t\t\t\t//modifycontent =$(\"#modifyform textarea\").val();\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t\tmodiout = modifycontent.replace(/\\n/g, \"<br>\");\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t\treply_content= $(\"#modifyform\").parent();\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t\t$(\"#modifyform\").appendTo($(\"body\"));\r\n");
      out.write("\t\t\t\t$(\"#modifyform\").hide();\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t\t//화면 수정 \r\n");
      out.write("\t\t\t\t//reply_content.html(modiout);\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t\t//db 수정 - 수정 성공했을때 화면 수정 \r\n");
      out.write("\t\t\t\treplyUpdate();\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t\t})\r\n");
      out.write("\t\t\t$(\"#btnreset\").on(\"click\", function(){\r\n");
      out.write("\t\t\t\treplyReset();\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t});\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\r\n");
      out.write("\t})\r\n");
      out.write("\r\n");
      out.write("</script>\r\n");
      out.write("\r\n");
      out.write("<style>\r\n");
      out.write("hr {\r\n");
      out.write("\tmargin: 0.5rem;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("p {\r\n");
      out.write("\tmargin: 0;\r\n");
      out.write("\tpadding-left: 1rem;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".hr1 {\r\n");
      out.write("\tborder: 0;\r\n");
      out.write("\theight: 2px;\r\n");
      out.write("\tbackground: black;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".wdc {\r\n");
      out.write("\tpadding: 0 1rem;\r\n");
      out.write("\tdisplay: flex;\r\n");
      out.write("\tjustify-content: space-between;\r\n");
      out.write("\talign-items: center;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".hr2 {\r\n");
      out.write("\tborder: 0;\r\n");
      out.write("\theight: 1px;\r\n");
      out.write("\tbackground: #ccc;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".pp {\r\n");
      out.write("\tposition: relative;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".center {\r\n");
      out.write("\tposition: absolute;\r\n");
      out.write("\twidth: 70%;\r\n");
      out.write("\tleft: 300px;\r\n");
      out.write("\ttop: 0;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".col-lg-8 {\r\n");
      out.write("\tmax-width: 100% !important;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("#title {\r\n");
      out.write("\tpadding-left: 1rem;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".lead {\r\n");
      out.write("\theight: 300px;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("#title {\r\n");
      out.write("\tfont-weight: bold;\r\n");
      out.write("\tfont-size: 1.1rem;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".ud-btn {\r\n");
      out.write("\tdisplay: flex;\r\n");
      out.write("\tjustify-content: flex-end;\r\n");
      out.write("\talign-items: center;\r\n");
      out.write("\tpadding-right: 1rem;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".ud-btn button {\r\n");
      out.write("\tmargin-left: 0.5rem;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".action-first {\r\n");
      out.write("\tmargin-left: 100px;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("#modifyform {\r\n");
      out.write("\tdisplay: none;\r\n");
      out.write("}\r\n");
      out.write("</style>\r\n");
      out.write("</head>\r\n");
      out.write("\r\n");
      out.write("<body>\r\n");
      out.write("\r\n");
      out.write("\t<div id=\"modifyform\">\r\n");
      out.write("\t\t<textarea rows=\"5\" cols=\"40\"></textarea>\r\n");
      out.write("\t\t<input type=\"button\" value=\"확인\" id=\"btnok\"> <input\r\n");
      out.write("\t\t\ttype=\"button\" value=\"취소\" id=\"btnreset\">\r\n");
      out.write("\t</div>\r\n");
      out.write("\r\n");
      out.write("\t<a href=\"");
      out.print(request.getContextPath());
      out.write("/view/notice.jsp\"></a>\r\n");
      out.write("\r\n");
      out.write("\t<section class=\"py-5\">\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\t\t<div class=\"pp\">\r\n");
      out.write("\t\t\t<div class=\"center\">\r\n");
      out.write("\t\t\t\t<!-- Post Content Column-->\r\n");
      out.write("\t\t\t\t<div class=\"col-lg-8\">\r\n");
      out.write("\t\t\t\t\t<!-- Date/Time-->\r\n");
      out.write("\t\t\t\t\t<hr class=\"hr1\">\r\n");
      out.write("\t\t\t\t\t<span id=\"title\">");
      out.print(vo.getNotice_title());
      out.write("</span>\r\n");
      out.write("\t\t\t\t\t<hr class=\"hr2\">\r\n");
      out.write("\t\t\t\t\t<div class=\"wdc\">\r\n");
      out.write("\t\t\t\t\t\t<span class=\"writer\">작성자 : ");
      out.print(vo.getAdmin_id());
      out.write("</span> \r\n");
      out.write("\t\t\t\t\t\t<span class=\"date\">등록일 : ");
      out.print(vo.getNotice_date());
      out.write("</span> \r\n");
      out.write("\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t<hr class=\"hr2\">\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t<!-- 내용-->\r\n");
      out.write("\t\t\t\t\t<div class=\"ud-btn\">\r\n");
      out.write("\t\t\t\t\t\t<input id=\"btnUpdate\" type=\"button\" value=\"수정\"> \r\n");
      out.write("\t\t\t\t\t\t<input id=\"btnDelete\" type=\"button\" value=\"삭제\"> \r\n");
      out.write("\t\t\t\t\t\t<input type=\"button\" id=\"btnList\" value=\"게시글 목록\">\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t<p>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t\t");

							List<ImgVO> imgList = vo.getImgList();
								for(ImgVO imgvo : imgList){
						
      out.write("\r\n");
      out.write("\t\t\t\t\t\t<img\r\n");
      out.write("\t\t\t\t\t\t\tsrc=\"");
      out.print(request.getContextPath());
      out.write("/images/imageView.do?imgno=");
      out.print(imgvo.getImg_no());
      out.write("\"\r\n");
      out.write("\t\t\t\t\t\t\tstyle=\"width: 400px;\"><br>\r\n");
      out.write("\t\t\t\t\t\t");

						}
						
      out.write("\r\n");
      out.write("\t\t\t\t\t\t");
      out.print(vo.getNotice_title());
      out.write("\r\n");
      out.write("\t\t\t\t\t</p>\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t<hr />\r\n");
      out.write("\t\t\t\t\t<!-- Comments Form-->\r\n");
      out.write("\t\t\t\t\t<div class=\"card my-4\">\r\n");
      out.write("\t\t\t\t\t\t<h5 class=\"card-header\">댓글</h5>\r\n");
      out.write("\t\t\t\t\t\t<div class=\"card-content\" id=\"replyView\"></div>\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t\t<div class=\"card-body\">\r\n");
      out.write("\t\t\t\t\t\t\t<form>\r\n");
      out.write("\t\t\t\t\t\t\t\t<div class=\"form-group\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<input type=\"hidden\" id=\"replyno\" name=\"replyno\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\tvalue=\"");
      out.print(vo.getNotice_no());
      out.write("\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<textarea name=\"replycontent\" id=\"replycontent\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\tclass=\"form-control\" rows=\"3\" placeholder=\"댓글을 달아주세요!\"></textarea>\r\n");
      out.write("\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t<button class=\"btn btn-primary\" id=\"resend\" type=\"button\">댓글작성</button>\r\n");
      out.write("\t\t\t\t\t\t\t</form>\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t<!-- Single Comment-->\r\n");
      out.write("\t\t\t\t\t<!-- Comment with nested comments-->\r\n");
      out.write("\t\t\t\t\t<div class=\"media mb-4\"></div>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t</section>\r\n");
      out.write("\t<!-- Bootstrap core JS-->\r\n");
      out.write("\r\n");
      out.write("\t<script\r\n");
      out.write("\t\tsrc=\"https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/js/bootstrap.bundle.min.js\"></script>\r\n");
      out.write("\t<!-- Core theme JS-->\r\n");
      out.write("\t<script src=\"js/scripts.js\"></script>\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}