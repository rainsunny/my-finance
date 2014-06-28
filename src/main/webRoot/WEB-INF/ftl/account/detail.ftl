<#import "../lib/my_macro.ftl" as my>
<@my.html title="Account | Account Detail">

<div class="container">
    <div class="row">

        <div class="col-md-6 col-md-offset-2">


            <h2>Account Detail</h2>

            <form class="form-horizontal" role="form" method="post" action="">

                <div class="form-group">
                    <label class="col-md-4 control-label">Account Name</label>

                    <div class="col-md-8">
                        <p class="form-control-static">${account.name}</p>
                    </div>
                </div>

                <div class="form-group">
                    <label class="col-md-4 control-label">Description</label>

                    <div class="col-md-8">
                        <p class="form-control-static">${account.desc}</p>
                    </div>

                </div>

                <div class="form-group">
                    <label class="col-md-4 control-label">Owner</label>

                    <div class="col-md-8">
                        <p class="form-control-static">${account.owner.desc}</p>
                    </div>

                </div>

                <div class="form-group">
                    <label class="col-md-4 control-label">Account Type</label>

                    <div class="col-md-8">
                        <p class="form-control-static">${account.accountType.desc}</p>
                    </div>

                </div>

                <div class="form-group">
                    <label class="col-md-4 control-label">Account Sub Type</label>

                    <div class="col-md-8">
                        <p class="form-control-static">${account.subType.desc}</p>
                    </div>

                </div>

                <div class="form-group">
                    <label class="col-md-4 control-label">Balance</label>

                    <div class="col-md-8">
                        <p class="form-control-static">${account.balance?string(",##0.00")}</p>
                    </div>

                </div>

                <div class="form-group">
                    <div class="col-md-offset-4 col-md-8">
                        <a href="/account/update.htm?id=${account.id}">
                            <button class="btn btn-default" type="button">Update Account</button>
                        </a>
                    </div>

                </div>


            </form>
        </div>

    </div>
</div>


</@my.html>