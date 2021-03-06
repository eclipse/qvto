#*******************************************************************************
# Copyright (c) 2013, 2018 Borland Software Corporation and others.
# All rights reserved. This program and the accompanying materials
# are made available under the terms of the Eclipse Public License v2.0
# which accompanies this distribution, and is available at
# http://www.eclipse.org/legal/epl-v20.html
#
# Contributors:
#     Borland Software Corporation - initial API and implementation
#*******************************************************************************
#!/usr/bin/perl

while (<>) {
  if ($_ =~ /.*\".*\"\,*/  &&  !($_ =~ /\@SuppressWarnings\(\"unchecked\"\)/)) {
    chomp $_;
    print $_, ' //$NON-NLS-1$', "\n";
  }
  else {
    print $_;
  }
}