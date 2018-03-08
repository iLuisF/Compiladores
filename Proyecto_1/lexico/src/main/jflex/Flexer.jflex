package com.kaab.compiladores.lexico;
%%
%public
%standalone
%unicode

IDENTIFICADOR = ([:letter:] | _ ) ([:letter:] | [:digit:] | _ )*