import {html, PolymerElement} from '@polymer/polymer/polymer-element.js';
import '@vaadin/vaadin-button/src/vaadin-button.js';
import '@vaadin/vaadin-grid/src/vaadin-grid.js';
import '@vaadin/vaadin-ordered-layout/src/vaadin-vertical-layout.js';
import '@vaadin/vaadin-ordered-layout/src/vaadin-horizontal-layout.js';

class InterfaceMain extends PolymerElement {

    static get template() {
        return html`
<style include="shared-styles">
                :host {
                    display: block;
                    height: 100%;
                }
            </style>
<vaadin-vertical-layout theme="spacing" style="width: 100%; height: 100%;" id="vaadin-vertical-layout">
 <vaadin-horizontal-layout id="horizontal-idioma" style="width: 100%;">
  <vaadin-vertical-layout id="vertical-idioma" style="align-items: flex-start;"></vaadin-vertical-layout>
  <h1 id="title-main" style="align-self: center; class=" title"></h1>
 </vaadin-horizontal-layout>
 <h3 id="descripcion-main" style="text-align: justify; margin: var(--lumo-space-l); padding: var(--lumo-space-l); margin-top: var(--lumo-space-s); padding-top: var(--lumo-space-s); margin-bottom: var(--lumo-space-s); padding-bottom: var(--lumo-space-s);"></h3>
 <vaadin-vertical-layout id="vertical-madridcielo"></vaadin-vertical-layout>
 <h3 id="p-distritos" style="text-align: justify; margin: var(--lumo-space-l); padding: var(--lumo-space-l); margin-bottom: var(--lumo-space-s); padding-bottom: var(--lumo-space-s); margin-top: var(--lumo-space-s); padding-top: var(--lumo-space-s);"></h3>
 <h3 id="pDistritos2" style="text-align: justify; margin: var(--lumo-space-l); padding: var(--lumo-space-l); margin-top: var(--lumo-space-s); padding-top: var(--lumo-space-s); margin-bottom: var(--lumo-space-s); padding-bottom: var(--lumo-space-s);"></h3>
 <vaadin-horizontal-layout id="vaadinHorizontalLayout">
  <vaadin-vertical-layout id="vertical-text-distritos" style="margin: var(--lumo-space-l); margin-top: var(--lumo-space-s); padding-top: var(--lumo-space-s); margin-bottom: var(--lumo-space-l); padding-bottom: var(--lumo-space-l); padding-left: var(--lumo-space-l); padding-right: var(--lumo-space-xs); margin-right: var(--lumo-space-xs);"></vaadin-vertical-layout>
  <vaadin-vertical-layout id="vertical-image" style="align-self: center; margin: var(--lumo-space-l); padding: var(--lumo-space-l); margin-top: var(--lumo-space-s); padding-top: var(--lumo-space-s); margin-right: var(--lumo-space-xl); margin-left: var(--lumo-space-xs); padding-left: var(--lumo-space-xs); padding-right: var(--lumo-space-xl);"></vaadin-vertical-layout>
 </vaadin-horizontal-layout>
 <vaadin-button id="boton-continuar" style="align-self: center; margin: var(--lumo-space-s); margin-bottom: var(--lumo-space-xl);">
   ¡Empezar! 
 </vaadin-button>
 <vaadin-vertical-layout id="vertical-footer" style="margin-bottom: var(--lumo-space-xs); padding-bottom: var(--lumo-space-xs); margin-top: var(--lumo-space-xs); padding-top: var(--lumo-space-xs);">
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
        return 'interface-main';
    }

    static get properties() {
        return {
            // Declare your properties here.
        };
    }
}

customElements.define(InterfaceMain.is, InterfaceMain);
