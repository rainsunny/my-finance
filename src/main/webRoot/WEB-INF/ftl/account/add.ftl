<#import "../lib/my_macro.ftl" as my>
<@my.html title="Account | Add Account">

<div class="container">

    <div class="row">
        <div class="col-md-6 col-md-offset-2">


            <h2>Add Account</h2>

            <form class="form-horizontal" role="form" method="post" action="/account/add-submit.htm">

                <div class="form-group">
                    <label class="col-md-4 control-label">Account Name</label>

                    <div class="col-md-8">
                        <input class="form-control" type="text" name="name"/>
                    </div>
                </div>

                <div class="form-group">
                    <label class="col-md-4 control-label">Description</label>

                    <div class="col-md-8">
                        <input class="form-control" type="text" name="desc"/>
                    </div>

                </div>

                <div class="form-group">
                    <label class="col-md-4 control-label">Owner</label>

                    <div class="col-md-8">
                        <select name="owner" class="form-control">
                            <#list owners as owner>
                                <option value="${owner}">${owner.desc}</option>
                            </#list>
                        </select>
                    </div>

                </div>

                <div class="form-group">
                    <label class="col-md-4 control-label">Account Type</label>

                    <div class="col-md-8">
                        <select name="type" class="form-control">
                            <#list types as type>
                                <option value="${type}">${type.desc}</option>
                            </#list>
                        </select>
                    </div>

                </div>

                <div class="form-group">
                    <label class="col-md-4 control-label">Account Sub Type</label>

                    <div class="col-md-8">
                        <select name="subType" class="form-control">
                            <#list subTypes as type>
                                <option value="${type}">${type.desc}</option>
                            </#list>
                        </select>
                    </div>

                </div>

                <div class="form-group">
                    <label class="col-md-4 control-label">Balance</label>

                    <div class="col-md-8">
                        <input class="form-control" type="text" name="balance"/>
                    </div>

                </div>

                <div class="form-group">
                    <div class="col-md-offset-4 col-md-8">
                        <button class="btn btn-default" type="submit">Add Account</button>
                    </div>
                </div>


            </form>
        </div>

    </div>

</div>

</@my.html>