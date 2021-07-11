POST method example JSON body:

{
"siteName":"test.com",
"category":[{
"name":"categorytest"
},
{
"name":"categorytest2"
}]
}

PATCH method example JSON body and URI:

http://myDomain.com/website/updateSite/domainToUpdate.com

{"category":[{
"name":"update1"
},
{
"name": "update2"
}
]}

GET method URI example:

http://myDomain.com/website/getSite/domainToCheck.com

DELETE method URI example:

http://myDomain.com/website/deleteSite/domainToDelete.com
