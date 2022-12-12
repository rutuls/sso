<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"  "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

<head>
    <meta charset="utf-8">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <meta name="robots" content="noindex, nofollow">

    <#if properties.meta?has_content>
        <#list properties.meta?split(' ') as meta>
            <meta name="${meta?split('==')[0]}" content="${meta?split('==')[1]}"/>
        </#list>
    </#if>
    <title>${msg("loginTitle",(realm.displayName!''))}</title>
    <link rel="icon" href="${url.resourcesPath}/img/favicon.ico" />
    <#if properties.stylesCommon?has_content>
        <#list properties.stylesCommon?split(' ') as style>
            <link href="${url.resourcesCommonPath}/${style}" rel="stylesheet" />
        </#list>
    </#if>
    <#if properties.styles?has_content>
        <#list properties.styles?split(' ') as style>
            <link href="${url.resourcesPath}/${style}" rel="stylesheet" />
        </#list>
    </#if>
    <#if properties.scripts?has_content>
        <#list properties.scripts?split(' ') as script>
            <script src="${url.resourcesPath}/${script}" type="text/javascript"></script>
        </#list>
    </#if>
    <#if scripts??>
        <#list scripts as script>
            <script src="${script}" type="text/javascript"></script>
        </#list>
    </#if>
  <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@300;400;500&display=swap" rel="stylesheet">
  <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
</head>

<body>
    <div class="login-container">
    <div class="header-container">
        <header>
            <img class="logo" src="${url.resourcesPath}/img/dd-logo.svg" alt="Data Dynamics">
        </header>
    </div>
    <div class="box-container">
        <h1>WELCOME TO OUR - <b>PLATFORM 1.0</b></h1>
        <p>You can access multi platform in one single place</p>
        <div class="box">
            <#if realm.password>
            <form id="kc-form-login" onsubmit="login.disabled = true; return true;" action="${url.loginAction}" method="post">
                <div class="login-input-container">
                
                <div class="form-field" style="margin-right:15px">
                    <#--  <label for="username"><#if !realm.loginWithEmailAllowed>${msg("username")}<#elseif !realm.registrationEmailAsUsername>${msg("usernameOrEmail")}<#else>${msg("email")}</#if></label>  -->

                    <#if usernameEditDisabled??>
                        <input tabindex="1" id="username" class="textbox" name="username" value="${(login.username!'')}" type="text" disabled />
                    <#else>
                        <input tabindex="1" id="username" class="textbox" name="username" placeholder="Username" value="${(login.username!'')}"  type="text" autofocus autocomplete="off"
                               aria-invalid="<#if messagesPerField.existsError('username','password')>true</#if>"
                        />

                        <#if messagesPerField.existsError('username','password')>
                            <span id="input-error" class="input-error" aria-live="polite">
                                    ${kcSanitize(messagesPerField.getFirstError('username','password'))?no_esc}
                            </span>
                        </#if>
                    </#if>
                </div>

                <div>
                    <#--  <label for="password" class="${properties.kcLabelClass!}">${msg("password")}</label>  -->

                    <input tabindex="2" id="password" class="textbox" name="password" placeholder="Password" type="password" autocomplete="off"
                           aria-invalid="<#if messagesPerField.existsError('username','password')>true</#if>"
                    />
                </div>
                </div>

                <div class="form-options-container">
                        <div id="kc-form-buttons" class="button-container">
                      <input type="hidden" id="id-hidden-input" name="credentialId" <#if auth.selectedCredential?has_content>value="${auth.selectedCredential}"</#if>/>
                      <button type="submit" class="button" id="kc-login"><span>${msg("doLogIn")}</span></button>
                  </div>
                  </div>

               
            </form>
        </#if>
        </div>
    </div>
    <div class="login-img"></div>
</div>
<footer class="footer-container">
    <div>Contact : <a href="mailto:dd_product-support@datdyn.com">dd_product-support@datdyn.com</a></div>
    <div> © Copyright2022 Data Dynamics, Inc. All Rights Reserved</div>
    <div>
        <a href="https://www.datadynamicsinc.com/policies/privacy-policy/" target="_blank">Privacy
            Policy</a>&nbsp;.&nbsp;
        <a href="https://www.datadynamicsinc.com/policies/terms-of-use/" target="_blank">Terms of
            Service</a>&nbsp;.&nbsp;
        <a href="https://www.datadynamicsinc.com/policies/support-policies/" target="_blank">Support</a>
    </div>
</footer>
</body>
</html>