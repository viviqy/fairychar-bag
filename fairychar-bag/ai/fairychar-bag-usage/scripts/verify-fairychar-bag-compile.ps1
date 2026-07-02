param(
    [string]$Root = (Resolve-Path (Join-Path $PSScriptRoot '..\..\..\..')).Path
)

Set-StrictMode -Version Latest
$ErrorActionPreference = 'Stop'

Push-Location $Root
try {
    mvn -pl fairychar-bag -am -DskipTests compile
} finally {
    Pop-Location
}
