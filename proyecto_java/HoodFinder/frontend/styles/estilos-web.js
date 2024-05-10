
// eagerly import theme styles so as we can override them
import "@vaadin/vaadin-lumo-styles/all-imports";

import "@vaadin/vaadin-charts/theme/vaadin-chart-default-theme";

const $_documentContainer = document.createElement('template');

$_documentContainer.innerHTML = `
<custom-style>
  <style>

html {
 // --lumo-base-color: #F0F1CE;
 background-image: url('fondo2.jpeg');
 background-repeat: no-repeat;
 background-attachment: fixed;
 background-size: cover;
  --lumo-font-size: 1rem;
  --lumo-font-size-xxxl: 3rem;
  --lumo-font-size-xxl: 2.25rem;
  --lumo-font-size-xl: 1.75rem;
  --lumo-font-size-l: 1.375rem;
  --lumo-font-size-m: 1.125rem;
  --lumo-font-size-s: 1rem;
  --lumo-font-size-xs: 0.875rem;
  --lumo-font-size-xxs: 0.8125rem;
  --lumo-font-family: "Palatino Linotype", Palatino, Palladio, "URW Palladio L", "Book Antiqua", Baskerville, "Bookman Old Style", "Bitstream Charter", "Nimbus Roman No9 L", Garamond, "Apple Garamond", "ITC Garamond Narrow", "New Century Schoolbook", "Century Schoolbook", "Century Schoolbook L", Georgia, serif;
  --lumo-border-radius: calc(var(--lumo-size-m) / 2);
  --lumo-primary-text-color: rgb(28, 66, 115);
  --lumo-primary-color-50pct: rgba(28, 66, 115, 0.5);
  --lumo-primary-color-10pct: rgba(28, 66, 115, 0.1);
  --lumo-primary-color: hsl(214, 61%, 28%);
  --lumo-error-text-color: rgb(231, 24, 24);
  --lumo-error-color-50pct: rgba(231, 24, 24, 0.5);
  --lumo-error-color-10pct: rgba(231, 24, 24, 0.1);
  --lumo-success-text-color: rgb(62, 229, 170);
  --lumo-success-color-50pct: rgba(62, 229, 170, 0.5);
  --lumo-success-color-10pct: rgba(62, 229, 170, 0.1);
  --lumo-error-color: hsl(0, 81%, 50%);
  --lumo-success-color: hsl(159, 76%, 57%);
  --lumo-shade-5pct: rgba(26, 26, 26, 0.05);
  --lumo-shade-10pct: rgba(26, 26, 26, 0.1);
  --lumo-shade-20pct: rgba(26, 26, 26, 0.2);
  --lumo-shade-30pct: rgba(26, 26, 26, 0.3);
  --lumo-shade-40pct: rgba(26, 26, 26, 0.4);
  --lumo-shade-50pct: rgba(26, 26, 26, 0.5);
  --lumo-shade-60pct: rgba(26, 26, 26, 0.6);
  --lumo-shade-70pct: rgba(26, 26, 26, 0.7);
  --lumo-shade-80pct: rgba(26, 26, 26, 0.8);
  --lumo-shade-90pct: rgba(26, 26, 26, 0.9);
  --lumo-shade: hsl(0, 0%, 10%);
  --lumo-success-contrast-color: hsl(159, 29%, 10%);
  --lumo-header-text-color: hsl(261, 77%, 46%);
  --lumo-secondary-text-color: MidnightBlue;
}
  </style>
</custom-style>

<custom-style>
  <style>
    html {
      --material-font-family: "Helvetica Neue", Arial, sans-serif;
    }
  </style>
</custom-style>

`;

document.head.appendChild($_documentContainer.content);

