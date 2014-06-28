<#import "../lib/my_macro.ftl" as my>
<@my.html title="Account | Account List">

<div class="container">
    <div class="row">
        <div class="col-md-8 col-md-offset-2">

            <h2>Account List</h2>

            <table class="table">
                <tr>
                    <th>Account Type</th>
                    <th>Sub Type</th>
                    <th>Account Name</th>
                    <th>Balance</th>
                    <th>Category</th>
                    <th>Operation</th>
                </tr>
                <#list accounts as ac>
                    <tr>
                        <td>${ac.accountType.desc}</td>
                        <td>${ac.subType.desc}</td>
                        <td>${ac.name}</td>
                        <td class="text-right">${ac.balance?string(",##0.00")}</td>
                        <td>${ac.category!""}</td>
                        <td><a href="/account/detail.htm?id=${ac.id}">View</a></td>
                    </tr>
                </#list>

            </table>

        </div>
    </div>
</div>


</@my.html>