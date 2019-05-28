<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>
<html>
	<head>
		<title>add Emp</title>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link rel="stylesheet" type="text/css"
			href="<%=request.getContextPath() %>/css/style.css" />
	<script type="text/javascript" src ="<%=request.getContextPath() %>/js/jquery-1.4.3.js"></script>		
	<style type="text/css">
		.error_msg{
			color:red;
		}
	</style>		
	<script type="text/javascript">
			//校验用户名是否重复
			function check_name(name){
				//非空校验
				if(name ==  ""){
					$("#name_msg").text("资费名不能为空").addClass("error_msg");
				}else{
				//验证emp姓名
				$.post(
					//url请求地址
					"checkEmpName.action",
					//json字符串
					{"name":name},
					//回调函数
					function(result){
						//data接收返回数据的JSON
						//即{"message":"被占用","isrepeat":false}
						//alert(data.message);
						if(result.state==1){
							//不可以使用
							$("#name_msg").text(result.message).addClass("error_msg");
						}else{
							//可以使用
							$("#name_msg").text(result.message).attr("style","color:green");
						}
					}
				);
			}
			}
			
			
				
		
	    
	</script>		
			
	</head>

	<body>
		
		
		<div id="wrap">
			<div id="top_content">
					<div id="header">
						<div id="rightheader">
							<p>
								2009/11/20
								<br />
							</p>
						</div>
						<div id="topheader">
							<h1 id="title">
								<a href="#">Main</a>
							</h1>
						</div>
						<div id="navigation">
						</div>
					</div>
				<div id="content">
					<p id="whereami">
					</p>
					<h1>
						添加员工:
					</h1>
					
					<form action="addEmp.action" method="post" onsubmit="return check_name()">
						<table cellpadding="0" cellspacing="0" border="0"
							class="form_table">
							<tr>
								<td valign="middle" align="right">
									部门编号:
								</td>
								<td valign="middle" align="left">
									<input type="text" class="inputgri" name="emp.dept_id" />
								</td>
							</tr>
							<tr>
								<td valign="middle" align="right">
									姓名:
								</td>
								<td valign="middle" align="left">
									<input type="text" class="inputgri" name="emp.name" onblur="check_name(this.value);" 
										value="<s:property value="emp.name"/>"
									/>
									<!--姓名提示信息 -->
									<span id="name_msg"></span>
								</td>
							</tr>
							<tr>
								<td valign="middle" align="right">
									薪资:
								</td>
								<td valign="middle" align="left">
									<input type="text" class="inputgri" name="emp.salary" />
								</td>
							</tr>
							<tr>
								<td valign="middle" align="right">
									年龄:
								</td>
								<td valign="middle" align="left">
									<input type="text" class="inputgri" name="emp.age" />
								</td>
							</tr>
								<tr>
								<td valign="middle" align="right">
									婚否:
								</td>
								<td valign="middle" align="left">
									<input type="radio"  name="emp.marry" value="Y" />是
									<input type="radio"  name="emp.marry" value="N" />否
								</td>
							</tr>
							</tr>
								<tr>
								<td valign="middle" align="right">
									生日:
								</td>
								<td valign="middle" align="left">
									<input type="text" class="inputgri" name="emp.birthday" />
								</td>
							</tr>
							
						</table>
						<p>
							<input type="submit" class="button" value="保存"  />
							<input type="reset" value="取消" class="button"/><br/>
							<span style="color:red;"><s:property value="message"/></span>
						</p>
					</form>
				</div>
			</div>
			<div id="footer">
				<div id="footer_bg">
					ABC@126.com
				</div>
			</div>
		</div>
	</body>
</html>
