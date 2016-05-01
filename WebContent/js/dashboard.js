$(document).ready( function () {
    $('#degreeTable').DataTable();
    
    $("#btnCreateTemplate").click(function(){
    	$("#templateForm").show();    	
    	$("#templateList").hide();
    });
    
    $("#templateBtn").click(function(){
    	$("#templateForm").hide();    	
    	$("#templateList").show();
    });
    
    $("#addFieldBtn").click(function(){
    	var newFieldInput = "<div class='form-group form-inline fieldInput'>"				
							+"<input name='fieldLabel' class='form-control' type='text' placeholder='Label of field' />	"				
    						+"<select class='form-control' name='fieldType'>"
    							+"<option>Number</option>"
    							+"<option>Text</option>"
    							+"<option>Date</option>"
    						+"</select>"
    						+"<button class='btn btn btn-danger removeFieldBtn'><i class='fa fa-times'></i> Remove</button>"
    						+"</div>";
    	$(newFieldInput).insertBefore($("#addFieldBtn"));
    	return false;
    });
    
    $("#templateForm").on("click",".removeFieldBtn", function(){
    	$(this).closest('.fieldInput').remove();
    });
});