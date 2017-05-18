var app = angular.module('app', ['ngRoute','ngResource']);
app.config(function($routeProvider){
    $routeProvider
        .when('/users',{
            templateUrl: '/views/users.html',
            controller: 'usersController'
        })
        .when('/roles',{
            templateUrl: '/views/roles.html',
            controller: 'rolesController'
        })
        .otherwise(
            { redirectTo: '/'}
        );
});

function addPostCode(V,e) 
{ 
var p=V.value; 
var ch="-" 
var q=String.fromCharCode(window.Event?e.which:e.keyCode); 

if(!isNaN(q)&&q!=" "){ 
if (p.length==2) { 
p=p+ch; 
V.value=p; 
return true; 
} 
if (p.length==6) { 
return false; 
} 
} else { 
return false; 
} 
} 


function adddateBirth(V,e) 
{ 
var p=V.value; 
var ch="-" 
var q=String.fromCharCode(window.Event?e.which:e.keyCode); 

if(!isNaN(q)&&q!=" "){ 
if (p.length==4) { 
p=p+ch; 
V.value=p; 
return true; 
} 
if (p.length==7) {
	p=p+ch; 
	V.value=p; 	
return true; 
}
if (p.length==10) {

return false; 
}
} else { 
return false; 
} 
} 

function addPhone(V,e) 
{ 
var p=V.value; 
var ch="-" 
var q=String.fromCharCode(window.Event?e.which:e.keyCode); 

if(!isNaN(q)&&q!=" "){ 
if (p.length==3) { 
p=p+ch; 
V.value=p; 
return true; 
} 
if (p.length==7) {
	p=p+ch; 
	V.value=p; 	
return true; 
}
if (p.length==11) {

return false; 
}
} else { 
return false; 
} 
} 