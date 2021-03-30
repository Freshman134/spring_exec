var update_table = function () {$.ajax({
	url: "http://localhost:8080/spring_exec/student",
 	success: function(data) {
 		var data = JSON.parse(data);
 		var table = function(data) {
 			var res = "";
 			for (var i = 0; i < data.length; i++) {
 				var sex = data[i].sex?"男":"女";
 				res += "<tr>";
 				res += "<td>" + data[i].studentId + "</td>";
 				res += "<td>" + data[i].name + "</td>";
 				res += "<td>" + data[i].no + "</td>";
 				res += "<td>" + sex + "</td>";
 				res += "<td>" + data[i].grade + "</td>";
 				res += "<td>" + data[i].className + "</td>";
	 			res += "</tr>";
 			}
 			return res;
 		};
 		
 		$("#stuTable").html(
 			"<tr>" + 
			"<td>studentId</td>" +
			"<td>name</td>" +
			"<td>no</td>" +
			"<td>sex</td>" +
			"<td>grade</td>" +
			"<td>className</td>" +
			"</tr>" + 
			table(data)
 		);
 	}
})}

// 入口函数
$(document).ready(function() {
	
	$("#get_be_update_btn").click(function () {
		var id = $("#no_update").val();
		$.ajax({
			url: "http://localhost:8080/spring_exec/student/" + id,
			success: function(data) {
				var data = JSON.parse(data);
				$("#name").val(data.name);
				$("#className").val(data.className);
				$("#no").val(data.no);
				$("#grade").val(data.grade);
				$("#u_studentId").val(data.studentId);
				if (data.sex == true) {
					$("#female").removeAttr("checked");
					$("#male").prop("checked", true);
				} else {
					$("male").removeAttr("checked");
					$("#female").prop("checked", true);
				}
			}
		});
	});
	
	$("#put_btn").click(function () {$.ajax({
		url: "http://localhost:8080/spring_exec/student/",
		data: {
			_method: "PUT",
			id: $("#u_studentId").val(),
			name: $("#name").val(),
			className: $("#className").val(),
			sex: $("input[name='u_sex']:checked").val(),
			no: $("#no").val(),
			grade: $("#grade").val()
		},
		type: 'POST',
		success: function() {
			update_table();
		}
	})});
	
	$("#del_btn").click(function () {$.ajax({
		url: "http://localhost:8080/spring_exec/student/",
		data: {
			_method: "DELETE",
			studentId: $("#del_id").val()
		}, 
		type: "POST",
		success: function() {
			update_table();
		}
	})});
	
	update_table();
	
});
