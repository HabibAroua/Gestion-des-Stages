$(document).ready
(
		function()
        {
			$("#submitBtn").click
            (
            		function()
        		    {
            			var firstName=document.getElementById("first_name").value;
        			    var lastName=document.getElementById("last_name").value;
        			    var dateBirth=document.getElementById("my_date").value;
        			    var cin=document.getElementById("cin").value;
        				if((firstName=="")&&(lastName=="")&&(dateBirth==""))
        				{
        					var url = $(this).prop('href');
            			    $("#submitBtn").load(url);
            			    event.preventDefault();
        				    $("#all").show();
        				}
        				else
        			    {
        					if(firstName=="")
							{
        						$("#submitBtn").load(url);
     			                event.preventDefault();
 							    $("#name").show();
							}
        					else
        					{
        						if(lastName=="")
        						{
        							$("#submitBtn").load(url);
         			                event.preventDefault();
         			               $("#last").show();
        						}
        						else
        						{
        							if(dateBirth=="")
        							{
        								$("#submitBtn").load(url);
             			                event.preventDefault();
             			                $("#birth").show();
        							}
        							else
        							{
        								if(cin=="")
        								{
        									$("#submitBtn").load(url);
                 			                event.preventDefault();
                 			                $("#cin").show();
        								}
        							}
        						}
        					}
        			    }  		 
        		    }
        	);
        }
 );
function URL_Del(obj)
{
    window.location.href = obj;
}