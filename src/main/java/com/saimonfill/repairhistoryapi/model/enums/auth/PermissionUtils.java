package com.saimonfill.repairhistoryapi.model.enums.auth;

public class PermissionUtils {
	//Expression parts
	public static final String HAS_AUTH_PREFIX = "hasAuthority('";
	public static final String HAS_ANY_AUTH_PREFIX = "hasAnyAuthority('";
	public static final String HAS_AUTH_SEP = "', '";
	public static final String HAS_AUTH_SUFFIX = "')";

	// Authorities / Permissions
	public final static String OWNER = "OWNER";
	public final static String ADMIN = "ADMIN";
	public final static String USER = "USER";

	// Pre-authorization expressions
	public final static String EXP_OWNER = HAS_AUTH_PREFIX + OWNER + HAS_AUTH_SUFFIX;
	public final static String EXP_OWNER_OR_ADMIN = HAS_ANY_AUTH_PREFIX + OWNER + HAS_AUTH_SEP + ADMIN + HAS_AUTH_SUFFIX;
	public final static String EXP_ADMIN = HAS_AUTH_PREFIX + ADMIN + HAS_AUTH_SUFFIX;
	public final static String EXP_USER = HAS_AUTH_PREFIX + USER + HAS_AUTH_SUFFIX;
}
