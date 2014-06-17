<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="shortcut icon" href="/favicon.ico">

    <title>Dashboard Template for Bootstrap</title>

    <link href="/css/bootstrap.css" rel="stylesheet">
    <link href="/css/dashboard.css" rel="stylesheet">

</head>

<body>

<#include "../header.ftl">

<div class="container-fluid">
    <div class="row">

        <#include "../sidebar.ftl">

        <#assign seq = ["1,001", "Lorem", "ipsum", "dolor", "sit"]>

        <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
            <h1 class="page-header">Dashboard</h1>

            <h2 class="sub-header">Section title</h2>
            <div class="table-responsive">
                <table class="table table-striped">
                    <thead>
                    <tr>
                        <th>#</th>
                        <th>Header</th>
                        <th>Header</th>
                        <th>Header</th>
                        <th>Header</th>
                    </tr>
                    </thead>
                    <tbody>
                    <#list 1..10 as i>
                    <tr>
                        <td>${seq[0]}</td>
                        <td>${seq[1]}</td>
                        <td>${seq[2]}</td>
                        <td>${seq[3]}</td>
                        <td>${seq[4]}</td>
                    </tr>
                    </#list>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</div>

<script src="/js/jquery-1.11.1.min.js"></script>
<script src="/js/bootstrap.js"></script>
</body>
</html>