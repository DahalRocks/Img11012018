<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>OverView</title>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/resources/css/me.css">
<script src="${pageContext.request.contextPath}/resources/js/jquery.js"></script>
<style type="text/css">
	input[type='button']{
	height: 30px;
    width: 218px;
    color: blue;
    font-weight: bold;
	}
</style>
</head>
<body>
        <header class="row">
            <div>Oslo Metropolitan University</div>
            <div>Department of Computer Science</div>
            <div>Faculty of Technology, Art and Design</div>
            
            
        </header>
        <section class=" row introduction-section">
            <div><span>Consent Form</span></div>
            <div><span>Title of Study:</span>Evaluation of Three Different Supportive Hints for Writing Image Description </div>
            <div class="investigator-info"><p><span>Investigator</span></p><p><span>Name:</span> Dhruba Dahal</p><p><span>Department:</span> Computer Science </p><p> <span>Email:</span> s310279@stud.hioa.no</p></div>
                        
            <div class="sub-heading">Introduction</div>
            <div class="intro-box">
                <p>This research is about writing image description. You are being invited to participate in an online experiment where you will be writing text descriptions for several images. The overall purpose of this research is to find the most usable way of helping people to make them write better image description.
                </p>
            </div>
            
        </section>
        <section class="row concent-section">
            <div class="sub-heading">Description of the Study Procedures</div>
            <div class="concent-box">
                <p>If you agree to be a participant then you will be asked to do the following:</p>
                <p><span>1. Pre-Questionnaires:</span></p>
                <p>You need to complete a Questionnaire based on your personal information</p>
                <p><span>2. Do Experiment:</span></p>
                <p>In this stage you will be provided three different images in each round of the experiment. There will be three rounds:first, second, and third round. Each round will start automatically when you finish writing for the last round. Finally, the evaluation round will start, where you will be provided nine different image descriptions written by other participants and you will be responsible to provide ratings for those descriptions as an evaluation. The instruction will be provided in the evaluation stage that explains on what basis you will perform the evaluation.</p>
                <p><span>Voluntary Participation:</span></p>
                <p>Your participation in this study is completely voluntary.</p>
                <p><span>Right to ask Questions and Report Concerns:</span></p>
                <p>You have the right to ask questions about this research.</p>
                <p>If you have any further questions about the study, at any time feel free to contact on the given information:</p>
                <p><span>Name:</span>Dhruba Dahal</p>
                <p><span>Email:</span> s310279@stud.hioa.no, dhruba.dahal03@gmail.com</p>
                <p><span>Thesis Supervisor:</span></p>
                <p><span>Name:</span>Raju Shrestha, Associate Professor</p>
                <p><span>Email:</span>Raju.Shrestha@hioa.no</p>
                <p><span>Confirmation and Consent</span></p>
                
            </div>
            <div class="concent-ok">
                <div><label for="chkok" aria-label="Checkbox"></label><input type="checkbox" name="chkOk"></div>
                <div><p>I have read the above information and ready to participate in this experiment.</p></div>
                <div><input type="button" value="Proceed" name="btnOk"></div>
            </div>
        
        </section>
    
    
    </body>
<script>
        $(document).ready(function(){
           
            
            $('input[type="button"]').click(function(){
                var chkvalue= $('input[type="checkbox"]:checked').val();
                if(chkvalue){
                    
                    window.location.replace('${pageContext.request.contextPath}/getuserdetailform');
                }
                else{
                    alert('Please check chekbox!!')
                }
                
            });
            
            
        });
    
    </script>
</html>