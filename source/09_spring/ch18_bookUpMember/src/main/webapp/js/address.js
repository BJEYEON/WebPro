/**
 * 주소검색 오픈 api
 */
	function sample4_execDaumPostcode() {
		new daum.Postcode({
            oncomplete: function(data) {
               
                var fullRoadAddr = data.roadAddress; 
                var extraRoadAddr = ''; 

                if(data.bname !== '' && /[동|로|가]$/g.test(data.bname)){
                    extraRoadAddr += data.bname;
                }
                if(data.buildingName !== '' && data.apartment === 'Y'){
                   extraRoadAddr += (extraRoadAddr !== '' ? ', ' + data.buildingName : data.buildingName);
                }
                if(extraRoadAddr !== ''){
                    extraRoadAddr = ' (' + extraRoadAddr + ')';
                }
                if(fullRoadAddr !== ''){
                    fullRoadAddr += extraRoadAddr;
                }
                document.getElementById('sample4_postcode').value = data.zonecode; 
                document.getElementById('sample4_roadAddress').value = fullRoadAddr;
                document.getElementById('sample4_jibunAddress').value = data.jibunAddress;

               
                if(data.autoRoadAddress) {
                    
                    var expRoadAddr = data.autoRoadAddress + extraRoadAddr;
                } else if(data.autoJibunAddress) {
                    var expJibunAddr = data.autoJibunAddress;
                }
            }
        }).open();
    }