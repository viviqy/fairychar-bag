param(
    [string]$Root = ""
)

$ErrorActionPreference = "Stop"

function Resolve-FairycharSrcRoot {
    param(
        [string]$RequestedRoot
    )

    if (-not [string]::IsNullOrWhiteSpace($RequestedRoot)) {
        return (Resolve-Path $RequestedRoot).Path
    }

    $candidates = New-Object System.Collections.Generic.List[string]
    $candidates.Add((Join-Path $PSScriptRoot "..\..\..\src"))
    $candidates.Add((Join-Path $PSScriptRoot "..\code\src"))

    $current = (Get-Location).Path
    while (-not [string]::IsNullOrWhiteSpace($current)) {
        $candidates.Add((Join-Path $current "fairychar-bag\src"))
        $candidates.Add((Join-Path $current "src"))

        $parent = Split-Path -Parent $current
        if ($parent -eq $current) {
            break
        }
        $current = $parent
    }

    foreach ($candidate in $candidates) {
        if (Test-Path -Path $candidate -PathType Container) {
            return (Resolve-Path $candidate).Path
        }
    }

    throw "Cannot find fairychar-bag/src or this skill's code/src. Pass -Root <path-to-source-root>."
}

if ([string]::IsNullOrWhiteSpace($Root)) {
    $Root = Resolve-FairycharSrcRoot ""
} else {
    $Root = Resolve-FairycharSrcRoot $Root
}
$excluded = '\\(target|build|\.git|\.idea|\.gradle|node_modules|out)\\'
$javaFiles = Get-ChildItem -Path $Root -Recurse -File -Filter *.java -Force |
    Where-Object { $_.FullName -notmatch $excluded }

$allFiles = Get-ChildItem -Path $Root -Recurse -File -Force |
    Where-Object { $_.FullName -notmatch $excluded }

$tabLines = 0
$longLines = 0
foreach ($file in $javaFiles) {
    $lineNo = 0
    foreach ($line in Get-Content -LiteralPath $file.FullName) {
        $lineNo++
        if ($line.Contains("`t")) {
            $tabLines++
        }
        if ($line.Length -gt 140) {
            $longLines++
        }
    }
}

$patterns = [ordered]@{
    "lombok_data" = "@Data"
    "chain_accessors" = "@Accessors(chain = true)"
    "slf4j" = "@Slf4j"
    "schema" = "@Schema"
    "conditional_property" = "@ConditionalOnProperty"
    "conditional_missing_bean" = "@ConditionalOnMissingBean"
    "rest_exception" = "RestException"
    "http_result" = "HttpResult"
    "private_utility_ctor" = "@NoArgsConstructor(access = AccessLevel.PRIVATE)"
    "consts_container" = "public final class Consts"
    "singletons_container" = "public class Singletons"
    "singleton_enum_holder" = "private enum Singleton"
}

Write-Output "root=$Root"
Write-Output "java_files=$($javaFiles.Count)"
Write-Output "all_files=$($allFiles.Count)"
Write-Output "tab_lines=$tabLines"
Write-Output "long_java_lines_gt_140=$longLines"

foreach ($entry in $patterns.GetEnumerator()) {
    $count = ($javaFiles | Select-String -Pattern $entry.Value -SimpleMatch -ErrorAction SilentlyContinue | Measure-Object).Count
    Write-Output "$($entry.Key)=$count"
}

$interfaces = ($javaFiles | Select-String -Pattern 'public interface I[A-Z]' -ErrorAction SilentlyContinue | Measure-Object).Count
$queries = ($javaFiles | Select-String -Pattern 'public class .*Query' -ErrorAction SilentlyContinue | Measure-Object).Count
$vos = ($javaFiles | Select-String -Pattern 'public class .*VO' -ErrorAction SilentlyContinue | Measure-Object).Count
$utils = ($javaFiles | Select-String -Pattern 'public final class .*Util' -ErrorAction SilentlyContinue | Measure-Object).Count
$templates = ($javaFiles | Select-String -Pattern 'public final class .*Template|public class .*Template' -ErrorAction SilentlyContinue | Measure-Object).Count

Write-Output "i_prefixed_interfaces=$interfaces"
Write-Output "query_classes=$queries"
Write-Output "vo_classes=$vos"
Write-Output "final_util_classes=$utils"
Write-Output "template_classes=$templates"

if ($tabLines -gt 0) {
    Write-Output "WARN: tab characters found in Java files."
}
if ($longLines -gt 0) {
    Write-Output "WARN: Java lines over 140 columns found; existing repo has some, avoid adding more."
}
