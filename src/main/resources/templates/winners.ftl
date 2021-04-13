<#import "parts/common.ftl" as c>

<@c.page>
    <div class="card-columns">
        <#list messages as message>
            <div class="card my-3">
                <#if message.filename??>
                    <img class="card-img-top" src="/img/${message.filename}"
                </#if>
                <span style="margin-left: 5px">${message.text}</span>
                <i style="color: rgba(23,23,23,0.66); text-align: right; margin-left: 5px;">${message.tag}</i>
                <div class="card-footer text-muted" style="text-align: right; ">
                    ${message.authorName}
                </div>
            </div>

        <#else>
            No messages
        </#list>
    </div>
</@c.page>