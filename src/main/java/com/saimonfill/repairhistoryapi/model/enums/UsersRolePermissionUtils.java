package com.saimonfill.repairhistoryapi.model.enums;

public class UsersRolePermissionUtils {
	//Expression parts
	public static final String HAS_AUTH_PREFIX = "hasAuthority('";
	public static final String HAS_ANY_AUTH_PREFIX = "hasAnyAuthority('";
	public static final String HAS_AUTH_SEP = "', '";
	public static final String HAS_AUTH_SUFFIX = "')";

	// Authorities / Permissions
	public final static String ADMIN = "ADMIN";
	public final static String USER = "USER";

	// Pre-authorization expressions
	public final static String EXP_ADMIN = HAS_AUTH_PREFIX + ADMIN + HAS_AUTH_SUFFIX;
	public final static String EXP_USER = HAS_AUTH_PREFIX + USER + HAS_AUTH_SUFFIX;
}
