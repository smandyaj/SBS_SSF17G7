function isNumberKey(evt)
       {
          var charCode = (evt.which) ? evt.which : evt.keyCode;
          if (charCode != 46 && charCode > 31 
            && (charCode < 48 || charCode > 57))
             return false;
          if (charCode == 46 && evt.srcElement.value.split('.').length>1) { return false; }

          return true;
       }

function isNum(evt)
{
   var charCode = (evt.which) ? evt.which : evt.keyCode;
   if (charCode > 31 
     && (charCode < 48 || charCode > 57))
      return false;

   return true;
}