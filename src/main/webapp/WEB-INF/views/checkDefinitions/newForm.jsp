<%@ page session="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
	<head>
		<title>新しいチェックリスト定義の作成</title>
		<script type="text/javascript" src="<c:url value="/scripts/jquery-1.4.min.js" /> "></script>
		<script type="text/javascript" src="<c:url value="/scripts/json.min.js" /> "></script>
	</head>
	<body>
		<div class="container">
			<h1>
				チェックリストの登録
			</h1>
			<div class="span-12 last">	
				<form:form modelAttribute="checkDefinition" action="checkDefinitions" method="post">
				  	<fieldset>		
						<legend>Account Fields</legend>
						<p>
							<form:label	id="nameLabel" for="name" path="name" cssErrorClass="error">Name</form:label><br/>
							<form:input path="name" /><form:errors path="name" />
						</p>
						<p>
							<form:label	id="descriptionLabel" for="description" path="description" cssErrorClass="error">Description</form:label><br/>
							<form:input path="description" /><form:errors path="description" />
						</p>
						<p>	
							<input id="create" type="submit" value="Create" />
						</p>
					</fieldset>
				</form:form>
			</div>
			<hr>	
			<ul>
				<li> <a href="?locale=en_us">us</a> |  <a href="?locale=en_gb">gb</a> | <a href="?locale=es_es">es</a> | <a href="?locale=de_de">de</a> </li>
			</ul>	
		</div>
	</body>

	<script type="text/javascript">	
  /*
		$(document).ready(function() {
			// check name availability on focus lost
			$('#name').blur(function() {
				if ($('#name').val()) {	
					checkAvailability();
				}
			});
			$("#account").submit(function() {
				var account = $(this).serializeObject();
				$.postJSON("account", account, function(data) {
					$("#assignedId").val(data.id);
					showPopup();
				});
				return false;				
			});
		});

		function checkAvailability() {
			$.getJSON("account/availability", { name: $('#name').val() }, function(availability) {
				if (availability.available) {
					fieldValidated("name", { valid : true });
				} else {
					fieldValidated("name", { valid : false, message : $('#name').val() + " is not available, try " + availability.suggestions });
				}
			});
		}

		function fieldValidated(field, result) {
			if (result.valid) {
				$("#" + field + "Label").removeClass("error");
				$("#" + field + "\\.errors").remove();
				$('#create').attr("disabled", false);
			} else {
				$("#" + field + "Label").addClass("error");
				if ($("#" + field + "\\.errors").length == 0) {
					$("#" + field).after("<span id='" + field + ".errors'>" + result.message + "</span>");		
				} else {
					$("#" + field + "\\.errors").html("<span id='" + field + ".errors'>" + result.message + "</span>");		
				}
				$('#create').attr("disabled", true);					
			}			
		}

		function showPopup() {
			$.getJSON("account/" + $("#assignedId").val(), function(account) {
				$("#confirmedName").val(account.name);
				$("#confirmedBalance").val(account.balance);
				$("#confirmedEquityAllocation").val(account.equityAllocation);
				$("#confirmedRenewalDate").val(account.renewalDate);
			});			
			$('body').css('overflow','hidden');
			$('#popup').fadeIn('fast');
			$('#mask').fadeIn('fast');
		}
		
		function closePopup() {
			$('#popup').fadeOut('fast');
			$('#mask').fadeOut('fast');
			$('body').css('overflow','auto');
			resetForm();
		}

		function resetForm() {
			$('#account')[0].reset();
		}
	*/	
	</script>
</html>
