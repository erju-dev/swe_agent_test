import {html, PolymerElement} from '@polymer/polymer/polymer-element.js';
import '@vaadin/vaadin-ordered-layout/src/vaadin-horizontal-layout.js';
import '@vaadin/vaadin-ordered-layout/src/vaadin-vertical-layout.js';

class InterfaceCuriosidades extends PolymerElement {

    static get template() {
        return html`
<style include="shared-styles">
                :host {
                    display: block;
                    height: 100%;
                }
            </style>
<vaadin-vertical-layout style="width: 100%; height: 100%; margin-bottom: var(--lumo-space-xl); padding-bottom: var(--lumo-space-xl);" id="vaadinVerticalLayout">
 <h1 id="title-datos-curiosos" style="align-self: center; margin: var(--lumo-space-xs); margin-top: var(--lumo-space-m); padding-top: var(--lumo-space-m);"></h1>
 <p id="descripcion-datos-curiosos" style="align-self: center; text-align: center; margin: var(--lumo-space-l);"></p>
 <vaadin-vertical-layout id="vertical-tabb"></vaadin-vertical-layout>
 <vaadin-horizontal-layout id="horizontal-graficas-S" style="align-self: center; margin: var(--lumo-space-s); flex-grow: 1; margin-top: var(--lumo-space-m); margin-bottom: var(--lumo-space-xs);">
  <vaadin-vertical-layout id="vertical-grafica-superficie" style="align-self: center; margin: var(--lumo-space-l); flex-grow: 1; margin-right: var(--lumo-space-s); margin-left: var(--lumo-space-s);"></vaadin-vertical-layout>
  <vaadin-vertical-layout id="vertical-text-superficie">
   <vaadin-vertical-layout id="vertical-text-sup" style="align-self: center; line-height: 1.25em; text-align: justify; width: 100%; margin: var(--lumo-space-m); font-size: 1em; padding-top: var(--lumo-space-l); margin-left: var(--lumo-space-xs); padding-bottom: var(--lumo-space-s);"></vaadin-vertical-layout>
   <vaadin-vertical-layout id="vertical-backtop-sup"></vaadin-vertical-layout>
  </vaadin-vertical-layout>
 </vaadin-horizontal-layout>
 <vaadin-horizontal-layout id="horizontal-graficasD" style="align-self: center; margin: var(--lumo-space-s); flex-grow: 1; margin-top: var(--lumo-space-xs);">
  <vaadin-vertical-layout id="vertical-text-densidad" style="margin-bottom: var(--lumo-space-xs); margin-top: var(--lumo-space-xl);">
   <vaadin-vertical-layout id="vertical-textD" style="align-self: center; line-height: 1.25em; text-align: justify; width: 100%; margin: var(--lumo-space-m); font-size: 1em; padding-top: var(--lumo-space-l); margin-left: var(--lumo-space-xs); padding-bottom: var(--lumo-space-s);"></vaadin-vertical-layout>
   <vaadin-vertical-layout id="verticalBacktopD" style="align-self: center; margin-top: var(--lumo-space-xs); padding-top: var(--lumo-space-xs);"></vaadin-vertical-layout>
  </vaadin-vertical-layout>
  <vaadin-vertical-layout id="vertical-grafica-densidad" style="align-self: center; margin: var(--lumo-space-l); flex-grow: 1; margin-bottom: var(--lumo-space-xs);"></vaadin-vertical-layout>
 </vaadin-horizontal-layout>
 <vaadin-vertical-layout id="vertical-graficasS" style="align-self: center; margin: var(--lumo-space-l); flex-grow: 1;">
  <vaadin-vertical-layout id="vertical-grafica-sexo" style="align-self: center; margin: var(--lumo-space-l); flex-grow: 1; margin-top: var(--lumo-space-xs); margin-bottom: var(--lumo-space-s);"></vaadin-vertical-layout>
  <vaadin-vertical-layout id="vertical-text-sexo" style="margin-right: var(--lumo-space-xl); margin-left: var(--lumo-space-xl); padding-right: var(--lumo-space-xl); padding-left: var(--lumo-space-xl);">
   <vaadin-vertical-layout id="vertical-textS" style="align-self: center; line-height: 1.25em; text-align: justify; width: 100%; margin: var(--lumo-space-m); font-size: 1em; padding-top: var(--lumo-space-l); margin-left: var(--lumo-space-xs); padding-bottom: var(--lumo-space-s);"></vaadin-vertical-layout>
   <vaadin-vertical-layout id="vertical-backtopSe" style="align-self: center; margin-top: var(--lumo-space-xs); padding-top: var(--lumo-space-xs);"></vaadin-vertical-layout>
  </vaadin-vertical-layout>
 </vaadin-vertical-layout>
 <vaadin-horizontal-layout id="horizontal-graficaL">
  <vaadin-vertical-layout id="vertical-grafica-lgtbi" style="margin-right: var(--lumo-space-s);"></vaadin-vertical-layout>
  <vaadin-vertical-layout id="vertical-text-lgtbi">
   <vaadin-vertical-layout id="vertical-textL" style="align-self: center; line-height: 1.25em; text-align: justify; width: 100%; margin: var(--lumo-space-m); font-size: 1em; padding-top: var(--lumo-space-l); margin-left: var(--lumo-space-xs); padding-bottom: var(--lumo-space-s);"></vaadin-vertical-layout>
   <vaadin-vertical-layout id="vertical-backtopL" style="align-self: center; margin-top: var(--lumo-space-xs); padding-top: var(--lumo-space-xs);"></vaadin-vertical-layout>
  </vaadin-vertical-layout>
 </vaadin-horizontal-layout>
 <vaadin-vertical-layout id="vertical-graficaP">
  <vaadin-vertical-layout id="vertical-grafica-politica" style="margin-bottom: var(--lumo-space-xs);"></vaadin-vertical-layout>
  <vaadin-vertical-layout id="vertical-text-politica" style="margin-top: var(--lumo-space-xs);">
   <vaadin-vertical-layout id="vertical-textP" style="align-self: center; line-height: 1.25em; text-align: justify; width: 100%; margin: var(--lumo-space-m); font-size: 1em; padding-top: var(--lumo-space-l); margin-left: var(--lumo-space-xs); padding-bottom: var(--lumo-space-s);"></vaadin-vertical-layout>
   <vaadin-vertical-layout id="vertical-backtopP" style="align-self: center; margin-top: var(--lumo-space-xs); padding-top: var(--lumo-space-xs);"></vaadin-vertical-layout>
  </vaadin-vertical-layout>
 </vaadin-vertical-layout>
 <vaadin-vertical-layout id="vertical-kaggle"></vaadin-vertical-layout>
 <vaadin-vertical-layout id="vertical-footer" style="margin-bottom: var(--lumo-space-xs); padding-bottom: var(--lumo-space-xs); margin-top: var(--lumo-space-xl); padding-top: var(--lumo-space-xs);">
  <vaadin-horizontal-layout id="horizontal-footer" style="margin-bottom: var(--lumo-space-xs); padding-bottom: var(--lumo-space-xs); margin-top: var(--lumo-space-xs); padding-top: var(--lumo-space-xs);">
   <vaadin-vertical-layout id="vertical-icons" style="align-self: stretch; margin-top: var(--lumo-space-l); padding-top: var(--lumo-space-l); margin-right: var(--lumo-space-xs); padding-right: var(--lumo-space-xs);">
    <vaadin-horizontal-layout id="horizontal-icon-mail" style="margin: var(--lumo-space-xs); padding: var(--lumo-space-xs); margin-right: var(--lumo-space-m); padding-right: var(--lumo-space-m);">
     <vaadin-horizontal-layout id="icono-mail" style="margin-right: var(--lumo-space-s); padding-right: var(--lumo-space-s);"></vaadin-horizontal-layout>madrid@hoodfinder.com 
    </vaadin-horizontal-layout>
    <vaadin-horizontal-layout id="horizontal-icon-phone" style="margin-right: var(--lumo-space-xs); padding-right: var(--lumo-space-xs);">
     <vaadin-horizontal-layout id="icono-phone" style="margin-right: var(--lumo-space-s); padding-right: var(--lumo-space-s);"></vaadin-horizontal-layout>+34 680 365 917 
    </vaadin-horizontal-layout>
   </vaadin-vertical-layout>
   <vaadin-vertical-layout id="vertical-icons-2" style="margin-top: var(--lumo-space-l); padding-top: var(--lumo-space-l); margin-left: var(--lumo-space-s); padding-left: var(--lumo-space-s);">
    <vaadin-horizontal-layout id="horizontal-icon-database" style="margin: var(--lumo-space-xs); padding-left: var(--lumo-space-xl); padding-bottom: var(--lumo-space-m);"></vaadin-horizontal-layout>
    <vaadin-horizontal-layout id="horizontal-icon-recycle" style="margin-left: var(--lumo-space-xs); padding-left: var(--lumo-space-xs); margin: var(--lumo-space-xs); padding: var(--lumo-space-xs); padding-top: var(--lumo-space-xs); margin-top: var(--lumo-space-xs);"></vaadin-horizontal-layout>
   </vaadin-vertical-layout>
   <vaadin-vertical-layout id="vertical-logo" style="margin-left: var(--lumo-space-xl); padding-left: var(--lumo-space-xl);"></vaadin-vertical-layout>
  </vaadin-horizontal-layout>
 </vaadin-vertical-layout>
</vaadin-vertical-layout>
`;
    }

    static get is() {
        return 'interface-curiosidades';
    }

    static get properties() {
        return {
            // Declare your properties here.
        };
    }
}

customElements.define(InterfaceCuriosidades.is, InterfaceCuriosidades);
